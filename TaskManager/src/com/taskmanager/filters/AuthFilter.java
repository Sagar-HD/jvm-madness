package com.taskmanager.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebFilter("/task")
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
		    res.setStatus(HttpServletResponse.SC_OK);
		    return;
		}
	    res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        res.setHeader("Access-Control-Allow-Credentials", "true");
	    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
	    res.setHeader("Access-Control-Allow-Headers", "Content-Type");
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
        	System.out.println("request interupted by filter unauthorized");
            res.setStatus(401);
            Map<String, Object> result = new HashMap<>();
            result.put("success", false);
            result.put("message", "unAuthorized access");
            res.getWriter().write(new Gson().toJson(result));
            return;
        }
   req.setAttribute("user", session.getAttribute("user"));
		
		chain.doFilter(request, response);
	}

	
}
