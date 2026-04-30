import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class DbUtil{
	
	public static Connection getConnection(){
		
		try{
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//optional for loading driver 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/passbook","root","Sagar@2412");
				
				if(con!=null){
					return con;
				}
				else{
					return null;
				}
				
				
				
				
						
		}
		catch(ClassNotFoundException | SQLException e){
			
			System.out.println(e.getMessage());
			return null;
			
		}
		
		
		
	}
	
	
}