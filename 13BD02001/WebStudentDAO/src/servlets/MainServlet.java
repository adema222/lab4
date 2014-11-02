package servlets;

//import models.HibernateUtil;
import models.Student;
import models.StudentDAOImpl;
//import models.StudentEntity;
//import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        List<StudentEntity> studentEntities = session.createCriteria(StudentEntity.class).list();
//
//        request.setAttribute("students", studentEntities);
        StudentDAOImpl dao = new StudentDAOImpl();
        List<Student> students = dao.findAll();

        request.setAttribute("students", students);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
