package com.taskmanager.controllers;

import com.taskmanager.dao.AuthDao;
import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;

public class AuthController {
	
	public boolean registerUser(User user){
		System.out.println("registering user "+user.getName());
		AuthDao authDao=new AuthDao();
		return authDao.registerUser(user);
	
	}
	public UserRes loginUser(String email,String password){
		System.out.println("logging in user "+email);
		AuthDao authDao=new AuthDao();
		return authDao.loginUser(email,password);
	
	}

}
