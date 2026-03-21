package com.passbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.passbook.Dao.PassbookDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		PassbookDao passbookDao=new PassbookDao();
		Account account=passbookDao.checkLogin(name, password);
		if(account!=null){
			HttpSession session=req.getSession();
		
			session.setAttribute("account",account);
			res.sendRedirect("Dashboard.jsp");
		}
		else{
			res.sendRedirect("index.jsp");
		}
		
	}

}
