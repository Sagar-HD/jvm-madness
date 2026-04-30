import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
class Jdbc{
	
	public static void main(String... args){
		
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sagar@2412");
			
			){
				String writeQuery="insert into users (name,email,age) values(?,?,?)";
				
				PreparedStatement writePs=con.prepareStatement(writeQuery);
				writePs.setString(1,"basavaraju");
				writePs.setString(2,"basava@gmail.com");
				writePs.setInt(3,68);
				int rowsInserted=writePs.executeUpdate();
				if(rowsInserted>0){
					System.out.println("data inserted sucessfully");
				}
				else{
					System.out.println("failed to insert data");
				}
				writePs.close();
				
				String readQuery="select * from users where name = ?";
				PreparedStatement readPs=con.prepareStatement(readQuery);
				readPs.setString(1,"basavaraju");
				ResultSet readResult=readPs.executeQuery();
				while(readResult.next()){
					System.out.println(readResult.getString("email"));
				}
				readPs.close();
				readResult.close();
				String updateQuery="update users set age = ? where name = ?";
				PreparedStatement updatePs=con.prepareStatement(updateQuery);
				updatePs.setInt(1,23);
				updatePs.setString(2,"basavaraju");
				rowsInserted=updatePs.executeUpdate();
				if(rowsInserted>0){
				System.out.println("data updated sucessfully");	
				}
				else{
				System.out.println("failed to update data");		
				}
				updatePs.close();
				String deleteQuery="delete from users where name = ?";
				PreparedStatement deletePs=con.prepareStatement(deleteQuery);
				deletePs.setString(1,"sagar");
				rowsInserted=deletePs.executeUpdate();
				if(rowsInserted>0){
				System.out.println("data delete sucessfully");	
				}
				else{
				System.out.println("failed to delete data");		
				}
				deletePs.close();
				
			}
		}
		catch(ClassNotFoundException  | SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
}