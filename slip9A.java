import java.sql.*;
public class slip9A
{
	public static void main(String [] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String database = "jdbc:mysql://localhost:3306/mydatabase";
		String username = "root";
		String password = "matsumoto";
		Connection con = DriverManager.getConnection(database,username,password);
		Statement st = con.createStatement();
		String q = "delete from emp where FullName like 'A%'";
		int n = st.executeUpdate(q);
		if(n==0)
		{
			System.out.println("No record found");
		}
		else
		{
			System.out.println("Record deleted successfully");
		}
		System.out.println("Printing the table after deletion");
		q = "select * from emp";
		ResultSet rs = st.executeQuery(q);
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		}
	}
}