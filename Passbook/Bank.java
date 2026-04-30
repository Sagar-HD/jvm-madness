import java.util.HashMap;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
class Bank{
	private HashMap<String,Account> accounts = new HashMap<>();
	public boolean isLoggedIn=false;
	private Account loggedInAccount=null;
	private AccountDAO accountDAO = new AccountDAO();
	void createAccount(long accountNumber,String password,String name){
		Account account=new Account(accountNumber,name,password);
		
		//this.accounts.put(accountNumber,account);
		int rowsInserted=this.accountDAO.register(account);
		if(rowsInserted>0){
		System.out.println("account created sucessfully");
		}else{
					System.out.println("account not created ");
		}
		
	}
	void login(String name,String password){
				if(name==null || password==null){
			System.out.println("invalid name or pass:");
			 throw new IllegalArgumentException("name and pass cannot be null");
		}
		//Account account=accounts.get(accountNumber);
		Account accountToLogin=this.accountDAO.getAccountByName(name);
		
		if(accountToLogin!=null){
			
			if(password.equals(accountToLogin.getPassword())){
				System.out.println("Logged in Succesfully");
				isLoggedIn=true;
				loggedInAccount=accountToLogin;
			}
			else{

				System.out.println("account number or password wrong");
				return;
			}
			
		}
		else{
				System.out.println("Account not found");
				return;
		}
		
	}
	
	void logout(){
		isLoggedIn=false;
		loggedInAccount=null;
		
	}
	void checkBalance(){
		double balance=accountDAO.getBalance(this.loggedInAccount);
		System.out.println("balance :"+balance);
	
	}
	
	void depositMoney(double amount){
		
		if(amount<=0){
			System.out.println("Invalid amount");
			return ;
		}
	
		try(Connection con=DbUtil.getConnection()){
		con.setAutoCommit(false);
		boolean sucess=accountDAO.depositMoney(amount,this.loggedInAccount,con);
		if(sucess){
			Transaction transaction=new Transaction(this.loggedInAccount.getAccountNumber(),"CREDIT",amount);
			boolean isTransactionsucess=accountDAO.addTransaction(transaction,con);
			if(isTransactionsucess){
				con.commit();
				System.out.println("deposited sucessfully");
			}
			else{
				con.rollback();
				System.out.println("deposited failed");
			}
			
		}
		else{
			con.rollback();
				System.out.println("deposited failed");
		}
		
		
		}
		catch(SQLException e){
			
			System.out.println("deposited failed");
			System.out.println(e.getMessage());
		}
		
	}
	
		void withdrawMoney(double amount){
		
		if(amount>accountDAO.getBalance(this.loggedInAccount)){
			System.out.println("Invalid amount , balance inssuficient");
			return ;
		}
		try(Connection con=DbUtil.getConnection()){
			con.setAutoCommit(false);
		boolean isWithdrawSucess=accountDAO.withdrawMoney(amount,this.loggedInAccount,con);
		if(isWithdrawSucess){
			Transaction transaction=new Transaction(this.loggedInAccount.getAccountNumber(),"DEBIT",amount);
			boolean isTransactionSucess=accountDAO.addTransaction(transaction,con);
			if(isTransactionSucess){
				con.commit();
				System.out.println("withdraw Money Sucess");
				return;
			}
			else{
				con.rollback();
				System.out.println("withdraw Money failed");
				return;
			}
		}
		else{
			con.rollback();
			System.out.println("withdraw Money failed");
		}
	
		}
		catch(SQLException e){
			System.out.println("withdraw Money failed");
			System.out.println(e.getMessage());
			
		}
	}
	void displayTransactions(){
		List<Transaction> transactions;
		transactions=accountDAO.getAllTransactions(this.loggedInAccount);
		
		for(Transaction transaction : transactions){
			System.out.println("Amount :"+transaction.getAmount()+" "+transaction.getType()+" on "+transaction.getDateTime());
		}
		
	}
	void save(){
		File file=new  File(this.loggedInAccount.getAccountNumber()+".txt");
		
		try{
			List<Transaction> transactions;
		transactions=accountDAO.getAllTransactions(this.loggedInAccount);
		
			file.createNewFile();
			System.out.println(this.loggedInAccount.getAccountNumber()+".txt file created");
			FileWriter writer=new FileWriter(file);
			
			for(Transaction transaction : transactions){
			writer.write("Amount :"+transaction.getAmount()+" "+transaction.getType()+" on "+transaction.getDateTime()+"\n");
		}
			
			writer.close();
			System.out.println("passbook saved ...");
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	public Account getLoggedInAccount(){
		return loggedInAccount;
	}
	
	
}