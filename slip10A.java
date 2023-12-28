// get count of total records without using any standard method

import java.sql.*;
public class slip10A
{
	public static void main(String [] args) throws Exception
	{
		int count = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String database = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "matsumoto";
		Connection con = DriverManager.getConnection(database,username,password);
		Statement st = con.createStatement();
		String q = "select * from emp";
		ResultSet rs = st.executeQuery(q);
		while(rs.next())
		{
			count++;
		}	
		System.out.println("The total count is : " + count);
		con.close();
	}
}