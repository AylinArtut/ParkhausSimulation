package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "carParkServlet", value = "/carParkServlet")
public class CarParkServlet extends HttpServlet{
    String information;
    Car car;
    CarPark carPark;

    public void init(){
        carPark = new CarPark("TraumParkhaus", 10, 1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        car = new Car();

        String spawnCar = request.getParameter("spawnCar");
        String kickCar = request.getParameter("kickCar");

        if (kickCar != null) {
            this.information = carPark.leaveCarPark();
        }

        if (spawnCar != null) {
            this.information = carPark.putCarToCarPark(car);
        }

        if(carPark.parkedCars == 0){
            this.information = String.format("Im Parkhaus sind %d Autos.", 0);
        }

        request.setAttribute("car", car);
        request.setAttribute("carPark", carPark);
        request.setAttribute("information", this.information);
        request.getRequestDispatcher("CarPark.jsp").forward(request, response);
    }
}