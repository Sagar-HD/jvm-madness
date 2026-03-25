package com.taskmanager.dao;


import com.taskmanager.model.Priority;
import com.taskmanager.model.Status;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;
import com.taskmanager.util.Dbutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

	public ArrayList<Task> getTasks(UserRes user) throws SQLException {
		try(Connection con = Dbutil.getConnection()){
			String query="select * from  tasks where user_id = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
					ps.setInt(1, user.getId());
					ArrayList<Task> tasks=new ArrayList<>();
					ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Task task=new Task(rs.getInt("user_id"),rs.getString("title"));
					if(rs.getString("description")!=null){
						task.setDescription(rs.getString("description"));
						
					}
					if(rs.getString("priority")!=null){
						task.setPriority(Priority.valueOf(rs.getString("priority")));
						
					}
					
					if(rs.getString("status")!=null){
						task.setStatus(Status.valueOf(rs.getString("status")));
						
					}
					if(rs.getString("deadline")!=null){
						task.setDate(LocalDateTime.parse(rs.getString("description")));
						
					}
             tasks.add(task);
				}
				return tasks;
			}
					
		}
		
	}

	public boolean deleteTask(int taskId) throws SQLException {
	try(Connection con=Dbutil.getConnection()){
		String query ="delete from tasks where id = ?";
		try(PreparedStatement ps=con.prepareStatement(query)){
			
			ps.setInt(1,taskId);
			int rows=ps.executeUpdate();
			if(rows>0){
				return true;
			}
		}
				
	}
		return false;
	}

}
