package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private int message;

    public void init() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("test") != null) {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + "</h1>");
            out.println("<br>");
            out.println("</body></html>");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}