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
      int rowAffected = pst.executeUpdate();
      if (rowAffected > 0) {
        flag = true;
      }
      pst.close();
      con.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return flag;
  }

  @Override
  public boolean insertStudent(Student s) {
    boolean flag = false;
    try {
      String myQuery =
        "insert into Students(sname,clgname,city,percentage) value(?,?,?,?)";
      Connection con = DBconnection.createConnection();
      PreparedStatement pst = con.prepareStatement(myQuery);
      pst.setString(1, s.getName());
      pst.setString(2, s.getClgname());
      pst.setString(3, s.getCity());
      pst.setDouble(4, s.getPercentage());
      int rowAffected = pst.executeUpdate();
      if (rowAffected > 0) {
        flag = true;
      }
      pst.close();
      con.close();
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
      rs.close();
      stmt.close();
      con.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean checkStudentRollno(int roll) {
    boolean flag = false;
    try {
      Connection con = DBconnection.createConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(
        "select * from students where rollnum=" + roll
      );
      if (rs.next()) {
        flag = true;
      }
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
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
      while (rs.next()) {
        flag = true;
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
      rs.close();
      stmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return flag;
  }

  @Override
  public boolean update(int roll, String update, int ch, Student S) {
    int choice = ch;
    boolean flag = false;

    try {
      if (choice == 1) {
        Connection con = DBconnection.createConnection();
        String query = "Update students set sname=? where rollnum=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, update);
        ps.setInt(2, roll);
        int rowAffected = ps.executeUpdate();
        if (rowAffected > 0) {
          flag = true;
        }
      } else if (choice == 2) {
        flag = true;
        Connection con = DBconnection.createConnection();
        PreparedStatement ps = con.prepareStatement(
          "update students set sname=? where rollnum=?"
        );
        ps.setString(1, update);
        ps.setInt(2, roll);
        int rowAffected = ps.executeUpdate();
        if (rowAffected > 0) {
          flag = true;
        }
        ps.close();
        con.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return flag;
  }
}
