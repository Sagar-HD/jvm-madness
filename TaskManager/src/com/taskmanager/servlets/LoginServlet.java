package com.taskmanager.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.taskmanager.dao.AuthDao;
import com.taskmanager.model.UserRes;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email=(String)req.getParameter("email");
		String password=(String)req.getParameter("password");
		  res.setContentType("application/json");
	      res.setCharacterEncoding("UTF-8");
		if( email==null || password==null  ){
			res.setStatus(400);
			Map<String, Object> result = new HashMap<>();
			result.put("success", false);
			result.put("message", "all fields required");

			
			res.getWriter().write(new Gson().toJson(result));
			return;
			
		}
		AuthDao authDao=new AuthDao();
		UserRes userRes=authDao.loginUser(email, password);
		if(userRes!=null){
		HttpSession session=req.getSession();
		session.setAttribute("user", userRes);
		res.setStatus(200);
		Map<String,Object> result=new HashMap<>();
		result.put("success", true);
		result.put("message", "user logged in success");
		result.put("user", userRes);
		res.getWriter().write(new Gson().toJson(result));
		return;
		}
		else{
			res.setStatus(409);
			Map<String,Object> result=new HashMap<>();
			result.put("success", false);
			result.put("message", "email or password wrong");
			res.getWriter().write(new Gson().toJson(result));
			return;
		}
		
	
	}

}
