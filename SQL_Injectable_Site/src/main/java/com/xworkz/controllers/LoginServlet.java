package com.xworkz.controllers;

import com.xworkz.dao.AuthDao;
import com.xworkz.dao.impl.AuthDaoImpl;
import com.xworkz.dto.Student;
import com.xworkz.service.AuthService;
import com.xworkz.service.impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthService authService;

    @Override
    public void init() {
        AuthDao authDao = new AuthDaoImpl();
        authService = new AuthServiceImpl(authDao);
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {

            req.setAttribute("error", "Username and Password are required");
            req.getRequestDispatcher("/login.jsp")
                    .forward(req, resp);
            return;
        }

        Student student = new Student(username, password);

        Student result = authService.login(student);

        if (result != null) {

            req.getSession().setAttribute("user", result);

            resp.sendRedirect(req.getContextPath() + "/success.jsp");

        } else {

            req.setAttribute("error", "Invalid Username or Password");
            req.getRequestDispatcher("/login.jsp")
                    .forward(req, resp);
        }
    }
}