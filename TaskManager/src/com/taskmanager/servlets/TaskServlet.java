package com.taskmanager.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.taskmanager.model.Priority;
import com.taskmanager.model.Task;
import com.taskmanager.model.UserRes;

import com.taskmanager.model.Status;


@WebServlet("/task")
public class TaskServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		
		
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
//		- user_id (FK)
//		- title
//		- description
//		- priority
//		- status
//		- deadline
		  res.setContentType("application/json");
	       res.setCharacterEncoding("UTF-8");
	       
		HttpSession session=req.getSession(false);
		if(session==null || session.getAttribute("user")==null){
			res.setStatus(401);
			Map<String,Object> result=new HashMap<>();
			result.put("success",false);
			result.put("message","unAuthorized access");
			res.getWriter().write(new Gson().toJson(result));
			return;
		}
		Object userObj=session.getAttribute("user");
		 UserRes user=null;
		if(userObj instanceof UserRes){
	      user=(UserRes)session.getAttribute("user");
		}
		if(user==null){
			res.setStatus(401);
			Map<String,Object> result=new HashMap<>();
			result.put("success",false);
			result.put("message","unAuthorized access");
			res.getWriter().write(new Gson().toJson(result));
			return;
		}
	    Integer user_id=user.getId();
		String title=req.getParameter("title");
		String description=req.getParameter("description");
		Priority priority=Priority.valueOf(req.getParameter("description"));
		Status status=Status.valueOf(req.getParameter("status"));
		LocalDateTime date=LocalDateTime.parse(req.getParameter("date"));
		if(user_id==null ||title==null){
			res.setStatus(400);
			Map<String, Object> json = new HashMap<>();
			json.put("success", false);
			json.put("message", "all fields required");

			
			res.getWriter().write(new Gson().toJson(json));
			return;
		}
		Task task=new Task(user_id,title);
		if(description!=null){
			task.setDescription(description);
		}
		if(priority!=null){
			task.setPriority(priority);
		}
		if(status!=null){
			task.setStatus(status);
		}
		if(date!=null){
			task.setDate(date);
		}
		
		
	}

}
