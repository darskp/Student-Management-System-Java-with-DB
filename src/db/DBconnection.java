package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

  static Connection con;

  public static Connection createConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con=DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student?autoReconnect=true&useSSL=false",
        "root",
        "Admin@123#"
      );

    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}
