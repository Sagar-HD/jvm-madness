package com.passbook.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.passbook.Account;
import com.passbook.Transaction;
import com.passbook.Dao.PassbookDao;


@WebFilter("/Dashboard.jsp")
public class AuthFilter implements Filter {

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq=(HttpServletRequest) req;
		HttpServletResponse httpRes=(HttpServletResponse) res;
		System.out.println("filter called");
		Account account=(Account)httpReq.getSession().getAttribute("account");
		double balance = 0;
		ArrayList<Transaction> transactions=new ArrayList<>();
		if(account==null){
			httpRes.sendRedirect("Hacker.jsp");
			return;
		}
		else{
		PassbookDao passbookDao=new PassbookDao();
		 balance=passbookDao.getBalance(account.getName());
		 transactions=passbookDao.getTransactions(account);
		 req.setAttribute("balance", balance);
		 req.setAttribute("account",account);
		 req.setAttribute("transactions", transactions);
		}
		chain.doFilter(httpReq, httpRes);
	}


}
