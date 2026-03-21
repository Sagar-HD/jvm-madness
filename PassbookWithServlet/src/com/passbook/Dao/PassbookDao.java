package com.passbook.Dao;
import java.sql.Connection;
import java.util.ArrayList;
import com.passbook.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.passbook.DbUtil.DbUtil;
public class PassbookDao {
	public Account checkLogin(String name,String password){
		try(Connection con=DbUtil.getConnection()){
			
			String query="select * from accounts where username=? and password=?";
			try(PreparedStatement ps=con.prepareStatement(query)){
			ps.setString(1,name);
			ps.setString(2,password);
			
			try(ResultSet rs=ps.executeQuery()){
			if(rs.next()){
				Account account=new Account(rs.getLong("account_number"),rs.getString("username"));
				return account;
			}
			}
			}
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
		}
		
		
		return null;
	}
	
	public boolean register(Account account){
		try(Connection con=DbUtil.getConnection()){
			
			String query="insert into accounts(account_number,username,password) values(?,?,?) ";
			try(PreparedStatement ps=con.prepareStatement(query)){
			ps.setLong(1,account.getAccountNumber());
			ps.setString(2,account.getName());
			ps.setString(3,account.getPassword());
		    int rows=ps.executeUpdate();
			if(rows>0){
				return true;
			}
			
			
			
		
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			
			
		}
		
		
		return false;
		
	
	}
	public double getBalance(String name){
		try(Connection con=DbUtil.getConnection()){
			String query="select balance from accounts where username = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setString(1, name);
				try(ResultSet rs=ps.executeQuery()){
					if(rs.next()){
						return rs.getDouble("balance");
					}
					else{
						
						System.out.println("failed to get balance");
						return 0.0;
					}
				}
			}
			
		}
		catch(SQLException e){
			
			e.printStackTrace();
			return 0.0;
		}
		
	}
	public boolean depositAmount(String name,Double amount,Connection con){
		try{
			String query="update accounts set balance=balance + ? where username = ? ";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setDouble(1, amount);
				ps.setString(2, name);
				int rows=ps.executeUpdate();
				if(rows>0){
					return true;
				}
				else{
					return false;
				}
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
			
		}
		
		
		}
	public boolean withdrawAmount(String name,Double amount,Connection con){
		try{
			String query="update accounts set balance=balance - ? where username = ? ";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setDouble(1, amount);
				ps.setString(2, name);
				int rows=ps.executeUpdate();
				if(rows>0){
					return true;
				}
				else{
					return false;
				}
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
			
		}
		
		
		}
	public boolean addTransaction(Transaction transaction,Connection con){
		try{
			String query="insert into transactions (account_number,type,amount) values (?,?,?)"	;
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setLong(1,transaction.getAccountNumber() );
				ps.setString(2,transaction.getType());
				ps.setDouble(3,transaction.getAmount());
				int rows=ps.executeUpdate();
				if(rows>0){
					return true;
				}
				else{
					return false;
				}
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
			
		}
		
		
		}
	public ArrayList<Transaction> getTransactions(Account account){
		try(Connection con=DbUtil.getConnection()){
			String query="select * from transactions where account_number = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setLong(1, account.getAccountNumber());
				ResultSet rs=ps.executeQuery();
				ArrayList<Transaction> transactions=new ArrayList<>();
				while(rs.next()){
					Transaction transaction=new Transaction(rs.getLong("account_number"),rs.getString("type"),rs.getDouble("amount"),rs.getTimestamp("date").toLocalDateTime());
				transactions.add(transaction);
				}
				return transactions;
			
		}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
			
		}
		}
	}
	


