package com.taskmanager.dao;


import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;
import com.taskmanager.util.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
public class TaskDao {
	public boolean addTask(Task task) throws SQLException{
		try(Connection con = Dbutil.getConnection()){
			String query="insert into tasks (user_id,title,description,priority,status,deadline) values (?,?,?,?,?,?)";
			try(PreparedStatement ps=con.prepareStatement(query)){
					ps.setInt(1, task.getUser_id());
					ps.setString(2, task.getTitle());
					ps.setString(3, task.getDescription());
					ps.setString(4, task.getPriority().toString());
					ps.setString(5, task.getStatus().toString());
					   if (task.getDate() != null) {
			                ps.setTimestamp(6, Timestamp.valueOf(task.getDate())); 
			            } else {
			                ps.setNull(6, Types.TIMESTAMP); 
			            }

					int rows=ps.executeUpdate();
					if(rows>0){
						return true;
					}
			}
					
		}
		return false;
	}

	public Task[] getTasks(UserRes user) throws SQLException {
		try(Connection con = Dbutil.getConnection()){
			String query="select * from  tasks where user_id = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
					ps.setInt(1, user.getId());
					
					int rows=ps.executeUpdate();
					if(rows>0){
						return null;
					}
			}
					
		}
		return null;
	}

}
