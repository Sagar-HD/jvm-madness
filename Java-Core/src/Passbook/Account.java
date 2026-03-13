import java.util.ArrayList;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
class Account{
	private String accountNumber;
	private String password;
	private double balance=0;
	private ArrayList<String> transactions =new ArrayList<>();
	
	public Account(String accountNumber,String password){
		if(accountNumber.length()!=10){
			System.out.println("invalid account number:");
			 throw new IllegalArgumentException("account number should be of 10 digits");
		}
		this.accountNumber=accountNumber;
		this.password=password;
		System.out.println("account created succesfully");
	}
	
	void displayTransactions(){
		
		
		for(String trans : transactions){
			System.out.println(trans);
		}
		
	}
	void save(){
		File file=new  File(this.accountNumber+".txt");
		try{
			
			file.createNewFile();
			System.out.println(this.accountNumber+".txt file created");
			FileWriter writer=new FileWriter(file);
			for(String trans : transactions){
			writer.write(trans + "\n");
		}
			
			writer.close();
			System.out.println("passbook saved ...");
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	void depositMoney(double amount){
		
		if(amount<=0){
			System.out.println("Invalid amount");
			return ;
		}
		LocalDateTime now = LocalDateTime.now();
		balance+=amount;
		transactions.add("Rs "+amount+" deposited on :"+now+": balance || "+balance);
		System.out.println("Rs "+amount+" deposited to account");
	}
	void withdrawMoney(double amount){
		
		if(amount>balance){
			System.out.println("Invalid amount , balance inssuficient");
			return ;
		}
		LocalDateTime now = LocalDateTime.now();
		balance-=amount;
		transactions.add("Rs "+amount+" withdrew on :"+now+": balance || "+balance);
		System.out.println("Rs "+amount+" withdrawn from account");
	}
		void checkBalance(){
		
		System.out.println("Balance Amount"+"Rs "+balance);
	}
	boolean checkPassword(String password){
		return this.password.equals(password);
	}
	
}