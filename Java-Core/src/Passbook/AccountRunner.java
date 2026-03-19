import java.util.Scanner;
class AccountRunner{
	
	
	public static void main(String[] args){
		Bank bank=new Bank();
		Scanner input = new Scanner(System.in);
		outer:while(!bank.isLoggedIn){
			
			System.out.println("press 1 to  create account");
			
			System.out.println("press 2 to login account");
			
			System.out.println("press 3 to exit");
			int choice=input.nextInt();
			input.nextLine();
			switch(choice){
				case 1:
				System.out.println("enter account number");
				long accountNumber=input.nextLong(); 
				System.out.println("enter name");
				String name=input.nextLine();
				System.out.println("enter password");
				String password=input.nextLine(); 
				bank.createAccount(accountNumber,name,password);
				break;
				case 2:
				System.out.println("enter name");
				String nameToLogin=input.nextLine(); 
				System.out.println("enter password");
				String passwordToLogin=input.nextLine(); 
				bank.login(nameToLogin,passwordToLogin);
				break;
				default:
				System.out.println("invalid input");
				break;
				case 3:
				break outer;
				
			}
			
		
		
		
		
		if(bank.isLoggedIn){
			Account account=bank.getLoggedInAccount();
		
		boolean loop=true;
		while(loop){
			System.out.println("press 1 to get balance");
			System.out.println("press 2 to deposit money");
			System.out.println("press 3 to withdraw money");
			System.out.println("press 4 to Display all transactions ");
			System.out.println("press 5 save passbook ");
			System.out.println("press 6 to logout ");
			System.out.println("press 7 to exit ");
			int option=input.nextInt();
			switch(option){
				case 1:
				bank.checkBalance();
				break;
				case 2:
					System.out.println("enter an amount to deposit");
					double amountTodeposit=input.nextDouble();
					bank.depositMoney(amountTodeposit);
				break;
				case 3:
				System.out.println("enter an amount to withdraw");
					double amountToWithdraw=input.nextDouble();
					bank.withdrawMoney(amountToWithdraw);
				break;
				case 4:
				System.out.println("printing all transactions");
				bank.displayTransactions();
				break;
				case 5:
				bank.save();
				break;
				case 6:
				bank.logout();
				loop=false;
				break;
				case 7:
				loop=false;
				break;
				
			}
		}
		}
		}
		
	}
	
	
}