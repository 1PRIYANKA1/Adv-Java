import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Corrected driver name
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String uname = "root";
            String pwd = "28priyanka2002";
            Connection con = DriverManager.getConnection(url, uname, pwd); // Establish connection
            Statement st = con.createStatement(); // Creates statement
            String q = "select * from emp";
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
