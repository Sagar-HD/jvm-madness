package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/add")
public class AddServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	int i=Integer.parseInt(req.getParameter("num1"));
	int j=Integer.parseInt(req.getParameter("num2"));
	int sum=i+j;
//	req.setAttribute("k", sum);
//	RequestDispatcher rd=req.getRequestDispatcher("square");
//	rd.forward(req,res);
	
	
//	HttpSession session=req.getSession();
//	session.setAttribute("k", sum);
//	res.sendRedirect("square");
	
Cookie 	cookie=new Cookie("k",sum+"");
res.addCookie(cookie);
res.sendRedirect("square");
	
}
}
