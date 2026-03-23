package com.taskmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;
import com.taskmanager.util.Dbutil;

public class AuthDao {
	public boolean checkUserExist(User user){
		try(Connection con=Dbutil.getConnection()){
		String uniqueQuery="select * from users where email = ?";
		try(PreparedStatement checkPs=con.prepareStatement(uniqueQuery)){
			checkPs.setString(1, user.getEmail());
			ResultSet rs=checkPs.executeQuery();
			if(rs.next()){
				
				return true;
			}
			else{
				return false;
			}
			
		}
		}
        catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return true;
	}
	public boolean registerUser(User user){
		try(Connection con=Dbutil.getConnection()){
			
			String query="insert into users (name,email,password) values(?,?,?)";
			
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setString(1, user.getName());
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getPassword());
				int rows=ps.executeUpdate();
				if(rows>0){
					return true;
				}
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public UserRes loginUser(String email,String password){
		try(Connection con=Dbutil.getConnection()){
			String query="select * from users where email = ? and password = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setString(1, email);
				ps.setString(2, password);
			
				try(ResultSet rs=ps.executeQuery()){
					if(rs.next()){
					UserRes userRes=new UserRes(rs.getInt("id"),rs.getString("email"),rs.getString("name"));
					return userRes;
					
					}
				}
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
