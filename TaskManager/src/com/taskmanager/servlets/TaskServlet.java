package com.taskmanager.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.taskmanager.controllers.TaskController;
import com.taskmanager.model.*;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        Object userObj = req.getAttribute("user");
        UserRes user = null;

        if (userObj instanceof UserRes) {
            user = (UserRes) userObj;
        }

        if (user == null) {
            res.setStatus(401);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "unAuthorized access");
            res.getWriter().write(new Gson().toJson(result));
            return;
        }
System.out.println("user in task"+user.getId());
        TaskController taskController = new TaskController();

        Map<String, Object> json = new HashMap<>();
        json.put("success", true);
        ArrayList<Task> tasks=new ArrayList<>();
        tasks=taskController.getTasks(user);
        json.put("tasks", tasks);

        res.getWriter().write(new Gson().toJson(json));
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        Object userObj = req.getAttribute("user");
        UserRes user = null;

        if (userObj instanceof UserRes) {
            user = (UserRes) userObj;
        }

        if (user == null) {
            res.setStatus(401);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "unAuthorized access");
            res.getWriter().write(new Gson().toJson(result));
            return;
        }
        System.out.println("user in task"+user.getId());
        Integer user_id = user.getId();

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String priorityStr = req.getParameter("priority");
        String statusStr = req.getParameter("status");
        String dateStr = req.getParameter("date");

        if (user_id == null || title == null || priorityStr == null || statusStr == null) {
            res.setStatus(400);
            Map<String, Object> json = new HashMap<>();
            json.put("success", false);
            json.put("message", "all fields required");
            res.getWriter().write(new Gson().toJson(json));
            return;
        }

        Priority priority = Priority.valueOf(priorityStr.toUpperCase());
        Status status = Status.valueOf(statusStr.toUpperCase());

        Task task = new Task(user_id, title);

        if (description != null) {
            task.setDescription(description);
        }

        task.setPriority(priority);
        task.setStatus(status);

        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                if (dateStr.length() == 16) {
                    dateStr = dateStr + ":00";
                }
                LocalDateTime date = LocalDateTime.parse(dateStr);
                task.setDate(date);
            } catch (Exception e) {
                res.setStatus(400);
                Map<String, Object> json = new HashMap<>();
                json.put("success", false);
                json.put("message", "invalid date format");
                res.getWriter().write(new Gson().toJson(json));
                return;
            }
        }

        TaskController taskController = new TaskController();
        boolean isSuccess = taskController.addTak(task);

        if (isSuccess) {
            res.setStatus(200);
            Map<String, Object> json = new HashMap<>();
            json.put("success", true);
            json.put("message", "task added succesfully");
            res.getWriter().write(new Gson().toJson(json));
        } else {
            res.setStatus(500);
            Map<String, Object> json = new HashMap<>();
            json.put("success", false);
            json.put("message", "internal server error");
            res.getWriter().write(new Gson().toJson(json));
        }
    }
    
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        Object userObj = req.getAttribute("user");
        UserRes user = null;

        if (userObj instanceof UserRes) {
            user = (UserRes) userObj;
        }

        if (user == null) {
            res.setStatus(401);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "unAuthorized access");
            res.getWriter().write(new Gson().toJson(result));
            return;
        }
      String taskString=req.getParameter("taskId");
      if(taskString==null){
          res.setStatus(400);
          Map<String, Object> json = new HashMap<>();
          json.put("success", false);
          json.put("message", "task id required");
          res.getWriter().write(new Gson().toJson(json));
          return;
      }
      int taskId=Integer.parseInt(taskString);
      
        TaskController taskController = new TaskController();
boolean isDeleteSuccess=taskController.deleteTask(taskId);
        Map<String, Object> json = new HashMap<>();
        if(isDeleteSuccess){
        json.put("success", true);
        json.put("message", "task deleted sucessfully");
        res.setStatus(200);
        res.getWriter().write(new Gson().toJson(json));
        return;
        }
        else{
        	 json.put("success", false);
             json.put("message", "internal server error");
             res.setStatus(500);
             res.getWriter().write(new Gson().toJson(json));
             return;	
        }
       
    }
    
}