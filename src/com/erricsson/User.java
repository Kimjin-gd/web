package com.erricsson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

	public static boolean match(String username, String password) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection("jdbc:mysql://localhost/training", "root", "mysql");
			PreparedStatement ps = 
					conn.prepareStatement("select * from users where username='" + username + "';");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
	//			String un = rs.getString(2);
				String psw = rs.getString(3);
				return password.equals(psw);
			}
		}catch(Exception e) {
			
		}
		return false;
	}
	
}
