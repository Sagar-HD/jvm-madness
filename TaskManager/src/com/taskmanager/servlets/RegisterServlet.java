package com.taskmanager.servlets;
import com.google.gson.Gson;
import com.taskmanager.controllers.AuthController;
import com.taskmanager.dao.AuthDao;
import com.taskmanager.model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
    	res.getWriter().write("just checking");
    }
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	String name=(String)req.getParameter("name");
	String email=(String)req.getParameter("email");
	String password=(String)req.getParameter("password");
	  
	   res.setContentType("application/json");
       res.setCharacterEncoding("UTF-8");
	if(name==null || email==null || password==null  ){
		res.setStatus(400);
		Map<String, Object> json = new HashMap<>();
		json.put("success", false);
		json.put("message", "all fields required");

		
		res.getWriter().write(new Gson().toJson(json));
		return;
		
	}
	User user=new User(name,email,password);
	AuthDao authDao=new AuthDao();
	
	boolean isUserExist=authDao.checkUserExist(user);
	if(isUserExist){
		
		
		res.setStatus(409);
		Map<String, Object> result = new HashMap<>();
		result.put("success", false);
		result.put("message", "user already exists");
		res.getWriter().write(new Gson().toJson(result));
		return;
	}
	AuthController authController=new AuthController();
	boolean isSuccess=authController.registerUser(user);
	if(isSuccess){
		res.setStatus(200);
		Map<String,Object> result=new HashMap<>();
		result.put("success", true);
		result.put("message", "data saved succesfully");
		res.getWriter().write(new Gson().toJson(result));
		return;
		
	}
	
	}

}
