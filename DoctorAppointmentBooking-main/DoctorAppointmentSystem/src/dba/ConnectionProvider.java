package dba;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection()
	{
		Connection con=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		 con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/testdb","root","1234");  
		 System.out.println("success");
	} catch (Exception e) {
		System.out.println("Error "+e);
	}
	return con;
	}

	}

