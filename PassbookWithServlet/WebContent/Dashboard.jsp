<%@ page import="com.passbook.Dao.PassbookDao,com.passbook.Account,java.util.ArrayList,com.passbook.Transaction" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="dashboard.css"/>
</head>
<body>
<%
Account account=(Account)session.getAttribute("account");
double balance = 0;
ArrayList<Transaction> transactions=new ArrayList<>();
if(account==null){
	response.sendRedirect("index.jsp");
}
else{
PassbookDao passbookDao=new PassbookDao();
 balance=passbookDao.getBalance(account.getName());
 transactions=passbookDao.getTransactions(account);
}
%>
<div class="dash">
<h1>Welcome to dashboard ${account.name}</h1>
<span>Balance = <%= balance %> </span>
<form action="deposit" method="post">
<label>Deposit money :</label>
<input type="number" placeholder="enter amount to deposit" name="depositAmount"/>
<button type="submit">Deposit</button>
</form>
<form action="withdraw" method="post">
<label>Deposit money :</label>
<input type="number" placeholder="enter amount to withdraw" name="withdrawAmount"/>
<button type="submit">Withdraw</button>
</form>
<form action="logout" method="post">
    <button type="submit">Logout</button>
</form>
<label>Transactions</label>
<table border="1">
<tr>
    <th>Amount</th>
    <th>Type</th>
    <th>Date</th>
</tr>

<%
for(Transaction tran : transactions){
%>
<tr>
    <td><%= tran.getAmount() %></td>
    <td><%= tran.getType() %></td>
    <td><%= tran.getDateTime() %></td>
</tr>
<%
}
%>
</table>
</div>
</body>
</html>