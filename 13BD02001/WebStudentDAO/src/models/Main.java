package models;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAOImpl dao = new StudentDAOImpl();
        List<Student> array = dao.findAll();

        Student student = dao.findById(3);
        System.out.println(student.getName());
    }
}
