import java.util.Scanner;
import java.util.List;
class Ui{
	
	public static void main(String... args) throws RestaurantNotFoundException{
		Scanner sc=new Scanner(System.in);
		RestaurantServices rs=new RestaurantServices();
		User loggedInUser=null;
		boolean run=true;
		while(run){
			int option;
		System.out.println("press 1 to login as admin");
		System.out.println("press 2 to login as customer");
		System.out.println("press 3 to register as customer");
		System.out.println("press 4 to exit");
	    option=sc.nextInt();
		sc.nextLine();
		switch(option){
			case 1:
			  System.out.println("Enter username ");
		String userName=sc.nextLine();
		System.out.println("Enter password ");
		String userPassword=sc.nextLine();
		if(rs.adminLogin(userName,userPassword)){
			System.out.println("admin logged in succesfully");
			
		}
		else{
			System.out.println("admin credentials wrong");
		}
			break;
			case 2:
			System.out.println("username of customer to login");
		String customerToLoginName=sc.nextLine();
		System.out.println("password of customer to login");
		String customerToLoginPassword=sc.nextLine();
		if(rs.customerLogin(customerToLoginName,customerToLoginPassword)){
			System.out.println("Customer logged in sucessfully");
		}
		else{
			System.out.println("Customer invalid creds");
		}
			break;
			case 3:
			System.out.println("username of customer to register");
		String customerUsername=sc.nextLine();
		System.out.println("password of customer to register");
		String customerPassword=sc.nextLine();
		rs.registerCustomer(customerUsername,customerPassword);
			break;
			case 4:
			run=false;
			break;
			default:
			System.out.println("invalid option");
			break;
			
		}
			loggedInUser=rs.getLoggedInUser();
			
			if(loggedInUser!=null){
			loggedInUser.showOptions(rs);
		}
		}
		
		//add menu
		System.out.println("enter resturant name to add menu");
		String name=sc.nextLine();
		Restaurant resToAddMenu=rs.getRestaurantByName(name);
		if(resToAddMenu!=null){
		System.out.println("enter item name to add");
		String itemName=sc.nextLine();
		System.out.println("enter price of item");
		int itemPrice=sc.nextInt();
		sc.nextLine();
		MenuItem menuItem=new MenuItem(itemName,itemPrice);
		resToAddMenu.addItemToMenu(menuItem);
		}
		else{
			throw new RestaurantNotFoundException("res not found");
		}
		// display menu of res
		List<MenuItem> menu=resToAddMenu.getMenuItems();
		System.out.println("printing menu");
		for(MenuItem item:menu){
			System.out.println(item.getName()+" : "+item.getPrice());
		}
		
		
		
	}
	
	
	
	
}