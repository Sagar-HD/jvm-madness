package com.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/square")
public class SquareServlet extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
	/*HttpSession session=req.getSession();*/
	
	
	/*int k = (int) session.getAttribute("k");
	 k=k*k;*/
	
	Cookie cookies[]=req.getCookies();
	int k = 0;
	for(Cookie c : cookies){
		if(c.getName().equals("k")){
			k=Integer.parseInt(c.getValue());
		}
			
	}
	k=k*k;
	res.getWriter().println("result :"+k);
	
	
}
}
