package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


interface StudentDAO {
    String dbURL = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "";

    public List<Student> findAll();
    Student findById(int id);
    Student findByName();
    boolean insert(Student student);
    boolean update(Student student);
    boolean delete(Student student);
}

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> findAll() {
        try {
            List<Student> array = new ArrayList<Student>();
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "SELECT * FROM Student";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()){
                    array.add(new Student(result.getInt("id"), result.getString("name"), result.getInt("year")));
                }

                return array;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Student findById(int id) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "SELECT * FROM Student WHERE id = " + id;

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                if (result.next()){
                    return new Student(result.getInt("id"), result.getString("name"), result.getInt("year"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Student findByName() {
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "SELECT * FROM Student";

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                if (result.next()){
                    return new Student(new Student(result.getInt("id"), result.getString("name"), result.getInt("year")));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insert(Student student) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "INSERT INTO Student (name, year) VALUES ('"+student.getName()+"', "+student.getYear()+")";

                Statement statement = conn.createStatement();
                int rowsInserted = statement.executeUpdate(sql);

                if (rowsInserted == 1){
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Student student) {

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "UPDATE student SET name='" + student.getName() + "', year="+student.getYear()+" WHERE id="+student.getId();

                Statement statement = conn.createStatement();
                int rowsChanged = statement.executeUpdate(sql);

                if (rowsChanged == 1){
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Student student) {
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) { // Connected
                String sql = "DELETE from Student where id="+ student.getId();

                Statement statement = conn.createStatement();
                int rowsDeleted = statement.executeUpdate(sql);

                if (rowsDeleted == 1){
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

