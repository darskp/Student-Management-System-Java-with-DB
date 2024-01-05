package main;

import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Student Management Application");
    while (true) {
      System.out.println(
        "\n1.Add Student" +
        "\n2.Show All Students+" +
        "\n3.Get student based on roll number+" +
        "\n4.Delete Student" +
        "\n5.Update Student" +
        "\n6.Exit"
      );
      System.out.println("Enter choice");

      int ch = sc.nextInt();
      switch (ch) {
        case 1:
          System.out.println("Add Student");
          break;
        case 2:
          System.out.println("Show All Students");
          break;
        case 3:
          System.out.println("Get students based on roll number");
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
