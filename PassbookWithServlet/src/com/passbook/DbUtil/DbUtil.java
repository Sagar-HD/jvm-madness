package com.passbook.DbUtil;
import java.sql.Connection;
import java.sql.DriverManager;
public class DbUtil {
	public static String url="jdbc:mysql://localhost:3306/passbook";
	public static String username="root";
	public static String password="Sagar@2412";
	
	public static Connection getConnection(){
		System.out.println("db util called");
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			     if(con!=null){
			    	
				return con;
			     }
			     else{
			    	 System.out.println("failed to connect");
			    	 return null;
			     }
			
		}
		catch(Exception e){
			
			e.printStackTrace(); 
			return null;
		}
		
	}

}
