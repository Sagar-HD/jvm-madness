package com.taskmanager.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.taskmanager.dao.AuthDao;
import com.taskmanager.model.User;
import com.taskmanager.model.UserRes;

@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {

    private void setCorsHeaders(HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        res.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        res.setHeader("Access-Control-Allow-Credentials", "true");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        setCorsHeaders(res);
        res.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        setCorsHeaders(res);

        Gson gson = new Gson();
        User user1 = gson.fromJson(req.getReader(), User.class);

        String email = user1.getEmail();
        String password = user1.getPassword();

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");

        System.out.println("login request received " + email + " " + password);

        if (email == null || password == null) {
            res.setStatus(400);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "all fields required");
            res.getWriter().write(gson.toJson(result));
            return;
        }

        AuthDao authDao = new AuthDao();
        UserRes userRes = authDao.loginUser(email, password);

        if (userRes != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userRes);

            res.setStatus(200);
            Map<String, Object> result = new HashMap<>();
            result.put("success", true);
            result.put("message", "user logged in success");
            result.put("user", userRes);
            res.getWriter().write(gson.toJson(result));
        } else {
            res.setStatus(409);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "email or password wrong");
            res.getWriter().write(gson.toJson(result));
        }
    }
}