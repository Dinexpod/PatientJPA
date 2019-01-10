package mate.academy.jpademo.controller;

import mate.academy.jpademo.model.Patient;
import mate.academy.jpademo.model.PatientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PatientsInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");

        Patient patient = new Patient();
        patient.setName("Jack");
        patient.setLastName("Bond");
        patient.setDate(new Date());
        req.setAttribute("patient", patient);

        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "Hello world" + "</h1>");
        req.getRequestDispatcher("view/patients/info.jsp").forward(req, resp);
    }
}
