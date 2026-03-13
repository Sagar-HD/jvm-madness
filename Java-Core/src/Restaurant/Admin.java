import java.util.Scanner;
class Admin extends User{
	
	
	Admin(String name,String password){
		super(name,password);
	}
	@Override
	public boolean validate(String name,String password){
		System.out.println(this.getName()+this.getPassword());
		return (this.getName().equals(name) && this.getPassword().equals(password));
	}
	public void showOptions(RestaurantServices rs){
		Scanner sc=new Scanner(System.in);
		int option;
		boolean run=true;
		while(run){
		System.out.println("press 1 to add restaurant");
		System.out.println("press 2 to add menu");
		System.out.println("press 3 to logout");
	    option=sc.nextInt();
		sc.nextLine();
		switch(option){
			case 1:
			System.out.println("enter restaurant name:");
			String restaurantName=sc.nextLine();
			Restaurant restaurant=new Restaurant(restaurantName);
		
		if(rs.addRestaurant(restaurant,restaurantName)){
			System.out.println("resturant added succesfully");
		}
		
			break;
			case 2:
			
			
			break;
			case 3:
			System.out.println("logging out..");
			rs.logoutUser();
			run=false;
			break;
			default:
			System.out.println("Invalid Options");
			
			
		}
		
		}
		
		
	}
}