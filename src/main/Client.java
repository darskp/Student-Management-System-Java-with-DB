package main;

import dao.StudentDao;
import dao.StudentDaoInterface;
import java.util.Scanner;
import model.Student;

public class Client {

  public static final String RED = "\u001B[31m";
  public static final String RESET = "\u001B[0m";
  public static final String GREEN = "\u001B[32m";
    public static final String CYAN="\u001B[36m";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StudentDaoInterface dao = new StudentDao();

    System.out.println(RED+"Welcome to Student Management Application"+RESET);

    while (true) {
      System.out.println(GREEN+
        "\n1.Add Student" +
        "\n2.Show All Students+" +
        "\n3.Get student based on roll number" +
        "\n4.Delete Student" +
        "\n5.Update Student" +
        "\n6.Exit"+RESET
      );

      System.out.println("Enter choice");

      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          System.out.println("Add Student");
          System.out.println("Enter student name");
          String name = sc.next();
          System.out.println("Enter student clg name");
          String clgName = sc.next();
          System.out.println("Enter city");
          String city = sc.next();
          System.out.println("Enter Percentage");
          double percentage = sc.nextDouble();
          Student st = new Student(name, clgName, city, percentage);
          boolean ans = dao.insertStudent(st);
          if (ans) {
            System.out.println("Record inserted Successfully!!!");
          } else {
            System.out.println("something went wrong, please try again");
          }
          break;
        case 2:
          System.out.println("Show All Students");
          dao.showAllStudent();
          break;
        case 3:
          System.out.println("Get students based on roll number");
          System.out.println("Enter the roll Number");
          boolean an = dao.showStudentByID(sc.nextInt());
          if (an == true) {
            System.out.println("Record found Successfully!!!");
          } else {
            System.out.println("Student with this id is not available");
          }
          break;
        case 4:
          System.out.println("Delete Student");
          System.out.println("enter roll number to delete");
          int rollnum = sc.nextInt();
          boolean checkRNoStat = dao.checkStudentRollno(rollnum);
          if (checkRNoStat) {
            boolean res = dao.delete(rollnum);
            if (res) {
              System.out.println("Record deleted successfully...");
            } else {
              System.out.println("Something went wrong");
            }
          } else {
            System.out.println("Entered Roll Number is not exist");
          }
          break;
        case 5:
          System.out.println("Update the student");
          System.out.println();
          System.out.println("1.Update Name\n2.Update College Name");
          System.out.println();
          System.out.println("Enter Your Choice ");
          int choice = sc.nextInt();
          if (choice == 1 || choice == 2) {
            System.out.println("Enter Roll Number ");
            int rnu = sc.nextInt();
            boolean checkRNoStatus = dao.checkStudentRollno(rnu);
            if (checkRNoStatus) {
              if (choice == 1) {
                System.out.println("Enter new name ");
                String sname = sc.next();
                Student std = new Student();
                std.setName(sname);
                boolean flag = dao.update(rnu, sname, choice, std);
                if (flag) {
                  System.out.println("Name Updated Successfully");
                } else {
                  System.out.println("Something went wrong....!");
                }
              } else if (choice == 2) {
                System.out.println("Enter New College name ");
                String collegeName = sc.next();
                Student std = new Student();
                std.setClgname(collegeName);
                boolean flag = dao.update(rnu, collegeName, choice, std);
                if (flag) {
                  System.out.println("College Name Updated Successfully");
                } else {
                  System.out.println("Something went wrong....!");
                }
              }
            } else {
              System.out.println("Entered Roll Number is not exist");
            }
          } else {
            System.out.println("Invalid Choice");
          }
          break;
        case 6:
          System.out.println("Thank you!");
          System.exit(0);
          break;
        default:
          System.out.println("Please enter valid choice..");

          break;
      }
    }
  }
}
