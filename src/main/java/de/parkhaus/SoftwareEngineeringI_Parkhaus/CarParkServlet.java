package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

// A servlet for handling server side stuff:
@WebServlet(name = "carParkServlet", value = "/carParkServlet")
public class CarParkServlet extends HttpServlet {
    Car car;
    CarPark carPark;
    String information;

    public void init(){
        // At the moment, I only need one car park (could be more in future):
        carPark = new CarPark("TraumParkhaus", 10, 1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        car = new Car();

        // Getting those information from "CarPark.jsp":
        String spawnCar = request.getParameter("spawnCar");
        String kickCar = request.getParameter("kickCar");

        // Some checks for different situations, which are very obvious:
        if (kickCar != null) {
            this.information = carPark.leaveCarPark();
        }
        if (spawnCar != null) {
            this.information = carPark.putCarToCarPark(car);
        }
        if(carPark.parkedCars == 0){
            this.information = String.format("Im Parkhaus sind %d Autos.", 0);
        }

        // To use them in "CarPark.jsp":
        request.setAttribute("car", car);
        request.setAttribute("carPark", carPark);
        request.setAttribute("information", this.information);
        request.getRequestDispatcher("CarPark.jsp").forward(request, response);
    }
}