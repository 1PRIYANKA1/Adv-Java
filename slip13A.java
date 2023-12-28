//package Slip13A;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class slip13A
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String uname = "root";
            String pwd = "matsumoto";
            Connection con = DriverManager.getConnection(urle,uname,pwd);
            Statement st = con.createStatement();
            String q= "create table Mobile(mno INT PRIMARY KEY,cname VARCHAR(45), price INT, color VARCHAR(45))";
            st.executeUpdate(q);
            q = "insert into Mobile values(1,'Vivo',12000,'Black')";
            st.executeUpdate(q);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
