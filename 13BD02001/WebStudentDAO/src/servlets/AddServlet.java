package servlets;

import models.Student;
import models.StudentDAOImpl;
//import models.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));

        Student student = new Student(0, name, year);
        StudentDAOImpl dao = new StudentDAOImpl();


        if (dao.insert(student)) {
            response.sendRedirect("main");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
