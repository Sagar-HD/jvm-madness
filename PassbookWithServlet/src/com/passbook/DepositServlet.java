package com.passbook;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import com.passbook.Dao.PassbookDao;
import com.passbook.DbUtil.DbUtil;


@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		double amount=Double.parseDouble(req.getParameter("depositAmount"));
		PassbookDao passbookDao = new PassbookDao();
		HttpSession session=req.getSession();
		Account account=(Account)session.getAttribute("account");
		try(Connection con=DbUtil.getConnection()){
			con.setAutoCommit(false);
		boolean isDepositSuccess=passbookDao.depositAmount(account.getName(), amount,con);
		Transaction transaction=new Transaction(account.getAccountNumber(),"CREDIT",amount);
		boolean isTransactionSaved=passbookDao.addTransaction(transaction, con);
		if(isDepositSuccess && isTransactionSaved){
			con.commit();
			res.sendRedirect("Dashboard.jsp");
		}
		else{
			con.rollback();
			res.sendRedirect("index.jsp");
		}
		
		}
		catch(SQLException e){
			e.printStackTrace();
		    res.sendRedirect("index.jsp");
		}
		
	}

}
