package model;

public class Student {

  private int rollNum;
  private String name;
  private String clgname;
  private String city;
  private double percentage;

//default
  public Student(){
  
  }

  @Override
  public String toString() {
    return (
      "Student [rollNum=" +
      rollNum +
      ", name=" +
      name +
      ", clgname=" +
      clgname +
      ", city=" +
      city +
      ", percentage=" +
      percentage +
      "]"
    );
  }

  public Student(String name, String clgname, String city, double percentage) {
    this.name = name;
    this.clgname = clgname;
    this.city = city;
    this.percentage = percentage;
  }

  public int getRollNum() {
    return rollNum;
  }

  public void setRollNum(int rollNum) {
    this.rollNum = rollNum;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getClgname() {
    return clgname;
  }

  public void setClgname(String clgname) {
    this.clgname = clgname;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public double getPercentage() {
    return percentage;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }
}
