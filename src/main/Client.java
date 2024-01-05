package main;

import dao.StudentDao;
import dao.StudentDaoInterface;
import java.util.Scanner;
import model.Student;

public class Client {

  public static void main(String[] args) { 

    Scanner sc = new Scanner(System.in);
    StudentDaoInterface dao = new StudentDao();

    System.out.println("Welcome to Student Management Application");

    while (true) {
      System.out.println(
        "\n1.Add Student" +
        "\n2.Show All Students+" +
        "\n3.Get student based on roll number" +
        "\n4.Delete Student" +
        "\n5.Update Student" +
        "\n6.Exit"
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
          boolean ans1=dao.showStudentByID(sc.nextInt());
          if (ans1) {
            System.out.println("Record found Successfully!!!");
          } else {
            System.out.println("something went wrong, please try again");
          }
          break;
        case 4:
          System.out.println("Delete Student");
          break;
        case 5:
          System.out.println("Update the student");
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
