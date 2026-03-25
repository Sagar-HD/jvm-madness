package com.taskmanager.controllers;

import java.sql.SQLException;

import com.taskmanager.dao.TaskDao;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;
import java.util.ArrayList;
public class TaskController {
	
	public boolean addTak(Task task){
		TaskDao taskDao=new TaskDao();
		boolean isSuccess;
		try {
			isSuccess = taskDao.addTask(task);
			if(isSuccess){
				return true;
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
		
		
		
		return false;
		}
	
	public ArrayList<Task> getTasks(UserRes user){
		TaskDao taskDao=new TaskDao();
		
		try {
		
			
				return 	taskDao.getTasks(user);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}
		
		
		
		
		return null;
	}
	
	
	public boolean deleteTask(int taskId){
		TaskDao taskDao=new TaskDao();
		
		try {
		
			
				return 	taskDao.deleteTask(taskId);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		}
		
		
		
		
		return false;
	}

}
