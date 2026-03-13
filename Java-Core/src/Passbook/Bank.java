import java.util.HashMap;
class Bank{
	private HashMap<String, Account> accounts = new HashMap<>();
	public boolean isLoggedIn=false;
	private Account loggedInAccount=null;
	void createAccount(String accountNumber,String password){
		Account account=new Account(accountNumber,password);
		this.accounts.put(accountNumber,account);
		System.out.println("account created sucessfully");
		
	}
	void login(String accountNumber,String password){
				if(accountNumber.length()!=10){
			System.out.println("invalid account number:");
			 throw new IllegalArgumentException("account number should be of 10 digits");
		}
		Account account=accounts.get(accountNumber);
		if(account!=null){
			if(account.checkPassword(password)){
				System.out.println("Logged in Succesfully");
				isLoggedIn=true;
				loggedInAccount=account;
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
	
	public Account getLoggedInAccount(){
		return loggedInAccount;
	}
	
	
}