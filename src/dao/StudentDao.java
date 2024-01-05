package dao;

import db.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Student;

public class StudentDao implements StudentDaoInterface {

  @Override
  public boolean delete(int roll) {
    boolean flag = false;
    try {
      Connection con = DBconnection.createConnection();
      String query = "DELETE from students where rollnum=" + roll;
      PreparedStatement pst = con.prepareStatement(query);
      flag=true;
      pst.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return flag;
  }

  @Override
  public boolean insertStudent(Student s) {
    boolean flag = false;
    try {
      flag = true;
      String myQuery =
        "insert into Students(sname,clgname,city,percentage) value(?,?,?,?)";
      Connection con = DBconnection.createConnection();
      PreparedStatement pst = con.prepareStatement(myQuery);
      pst.setString(1, s.getName());
      pst.setString(2, s.getClgname());
      pst.setString(3, s.getCity());
      pst.setDouble(4, s.getPercentage());
      pst.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public void showAllStudent() {
    try {
      Connection con = DBconnection.createConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(
          "Rollnumber : " +
          rs.getInt(1) +
          "\n" +
          "Name : " +
          rs.getString(2) +
          "\n" +
          "College Name : " +
          rs.getString(3) +
          "\n" +
          "City : " +
          rs.getString(4) +
          "\n" +
          "Percentage : " +
          rs.getDouble(5) +
          "\n"
        );
        System.out.println("------------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean showStudentByID(int roll) {
    boolean flag = false;
    try {
      Connection con = DBconnection.createConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
        "select * from students where rollnum=" + roll
      );
      flag = true;
      while (rs.next()) {
        System.out.println(
          "Rollnumber : " +
          rs.getInt(1) +
          "\n" +
          "Name : " +
          rs.getString(2) +
          "\n" +
          "College Name : " +
          rs.getString(3) +
          "\n" +
          "City : " +
          rs.getString(4) +
          "\n" +
          "Percentage : " +
          rs.getDouble(5) +
          "\n"
        );
        System.out.println("------------------");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean update(int roll, String update, int ch, Student S) {
    return false;
  }
}
