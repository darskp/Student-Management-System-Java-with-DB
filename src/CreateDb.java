import java.sql.*;

public class CreateDb {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "Admin@123#";
            String query = "SELECT * FROM students";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established successfully");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }

            st.close();
            con.close();
            System.out.println("Connection Closed....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
