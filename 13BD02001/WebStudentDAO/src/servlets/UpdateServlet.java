package servlets;


import models.Student;
import models.StudentDAOImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int year = Integer.parseInt(request.getParameter("year"));

        Student student = new Student(id, name, year);
        StudentDAOImpl dao = new StudentDAOImpl();
        if (dao.update(student)) {
            response.sendRedirect("main");
        } else {
            response.sendRedirect("update?id="+id); // error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAOImpl dao = new StudentDAOImpl();
        Student student = dao.findById(id);

        request.setAttribute("student", student);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }
}
