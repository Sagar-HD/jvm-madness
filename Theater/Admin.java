import java.util.Scanner;
class Admin extends User{
	@Override
	public void showMenu(Theater theater){
		
		Scanner scanner=new Scanner(System.in);
		int choice;
		do{
			
	System.out.println("press 1 view shows");
	System.out.println("press 2 to create shows");
	System.out.println("press 3 to logout");
	 
	choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice){
			case 1:
			theater.displayShows();
			break;
			case 2:
			theater.createShow();
			break;
			case 3:
			theater.logout();
			break;
			
		}
		}
		while(choice!=3);
		
	}
	
	
	 Admin(int userId,String name,String password){
		super(userId,name,password);
		System.out.println("admin created");
	
	}
	
	
	
	
	
	
}