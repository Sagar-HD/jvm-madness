package com.passbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passbook.Dao.PassbookDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		Long account_number=Long.parseLong(req.getParameter("account_number"));
		PassbookDao passbookDao=new PassbookDao();
		Account account=new Account(account_number,name,password);
		boolean isRegistered=passbookDao.register(account);
		if(isRegistered){
			res.sendRedirect("index.jsp");
		}
		else{
			res.sendRedirect("dashboard.jsp");
		}
		
	}

}
