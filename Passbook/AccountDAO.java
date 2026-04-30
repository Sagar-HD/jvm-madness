import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.LocalDateTime;
class AccountDAO{
	
	int register(Account accountToRegister){
		try(Connection con=DbUtil.getConnection()){
			if(con!=null){
			String accountRegisterQuery="insert into accounts (account_number,username,password) values(?,?,?)";
			try(
			PreparedStatement registerPs=con.prepareStatement(accountRegisterQuery))
			{
			registerPs.setLong(1,accountToRegister.getAccountNumber());
			registerPs.setString(2,accountToRegister.getName());
			registerPs.setString(3,accountToRegister.getPassword());
			return registerPs.executeUpdate();
			}
			}
			else{
				System.out.println("connection not found");
				return -1;
			}
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return -1;
		}
		
	}
	Account getAccountByName(String name){
				try(Connection con=DbUtil.getConnection()){
			if(con!=null){
			String getAccountByNameQuery="select * from accounts where username = ?";
			try(
			PreparedStatement getPs=con.prepareStatement(getAccountByNameQuery))
			{
			getPs.setString(1,name);
			
			ResultSet result= getPs.executeQuery();
			if(result.next()){
				Account account=new Account(result.getLong("account_number"),result.getString("username"),result.getString("password"));
				return account;
			}
			else{
				return null;
			}
			
			
			}
			}
			else{
				System.out.println("connection not found");
				return null;
			}
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	double getBalance(Account account){
		try(Connection con=DbUtil.getConnection()){
		String query="select balance from accounts where username= ?";
		try(PreparedStatement ps=con.prepareStatement(query)){
			ps.setString(1,account.getName());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return rs.getDouble("balance");
			}
			else{
				return -1;
			}
			
			
		}
		
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return -1;
		}
	}
	boolean depositMoney(double amount,Account account,Connection con){
		try{
			String query="update accounts set balance=balance + ? where username = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setDouble(1,amount);
			ps.setString(2,account.getName());
			int rows=ps.executeUpdate();
			if(rows>0){
				return true;
			}
			return false;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	boolean withdrawMoney(double amount,Account account,Connection con){
		try{
			String query="update accounts set balance=balance - ? where username = ? ";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setDouble(1,amount);
				ps.setString(2,account.getName());
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
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	boolean addTransaction(Transaction transaction,Connection con){
		try{
		String query="insert into transactions (account_number,type,amount) values (?,?,?)"	;
		try(PreparedStatement ps=con.prepareStatement(query)){
			ps.setLong(1,transaction.getAccountNumber());
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
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	ArrayList<Transaction> getAllTransactions(Account account){
		try(Connection con=DbUtil.getConnection()){
			String query="select * from transactions where account_number = ?";
			try(PreparedStatement ps=con.prepareStatement(query)){
				ps.setLong(1,account.getAccountNumber());
				try(ResultSet rs=ps.executeQuery()){
					ArrayList<Transaction> transactions=new ArrayList<>();
					while(rs.next()){
						long account_number=rs.getLong("account_number");
						String type=rs.getString("type");
						double amount=rs.getDouble("amount");
						LocalDateTime dateTime= rs.getTimestamp("date").toLocalDateTime();
						Transaction transaction=new Transaction(account_number,type,amount,dateTime);
						transactions.add(transaction);
					}
					return transactions;
				}
				
			}
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
}