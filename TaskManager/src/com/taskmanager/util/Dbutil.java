package com.taskmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	static final String url="jdbc:mysql://localhost:3306/taskmanager";
	static final String user="root";
	static final String password="Sagar@2412";
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
				return con;
			
		
			
		}
		catch(ClassNotFoundException e ){
			e.printStackTrace();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	

}
