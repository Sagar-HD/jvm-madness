import java.util.Scanner;
class Customer extends User{
	@Override
	public void showMenu(Theater theater){
		Scanner scanner=new Scanner(System.in);
		int choice;
		do{
			
	System.out.println("press 1 view shows");
	System.out.println("press 2 to book shows");
	System.out.println("press 3 to cancel shows");
	 System.out.println("press 4 to logout");
	 
	choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice){
			case 1:
			theater.displayShows();
			break;
			case 2:
			try{
			theater.bookSeat();
			}
			catch(seatNotAvailableException e){
			System.out.println(e);	
			}
			break;
			case 3:
			try{
			theater.cancelSeat();
			}
			catch(showNotFoundException e){
				 System.out.println(e);	
			}
			break;
			case 4:
			theater.logout();
			break;
			
		}
		}
		while(choice!=4);
		
	}
	
	public Customer(int userId,String name,String password){
		super(userId,name,password);
			System.out.println("customer created");
	}
	
	
	
}