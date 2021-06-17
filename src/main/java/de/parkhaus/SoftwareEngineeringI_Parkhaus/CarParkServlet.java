package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class CarParkServlet extends HttpServlet {
    String information;

    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.setContentType("text/html");

          PrintWriter out = response.getWriter();
          out.println("<html><body>");
          out.println("<h1>" + "</h1>");
          out.println("<br>");
          out.println("</body></html>");*/
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Car car = new Car();
        CarPark carPark = new CarPark("TraumParkhaus", 10, 0);

        String spawnCar = request.getParameter("spawnCar");
        String kickCar = request.getParameter("kickCar");

        if (kickCar != null) {
            this.information = carPark.leaveCarPark(car);
        }

        if (spawnCar != null) {
            this.information = carPark.putCarToCarPark(car);
        }

        request.setAttribute("car", car);
        request.setAttribute("carPark", carPark);
        request.setAttribute("information", this.information);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}