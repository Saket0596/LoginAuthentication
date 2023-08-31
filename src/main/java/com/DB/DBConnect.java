package com.DB;
import java.sql.*;

public class DBConnect {

	private static Connection conn;
	public static Connection getConnection() {
		try {
			if(conn==null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/authenticationlogin","root","2147");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
		
		
	}
}
