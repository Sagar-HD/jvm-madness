import java.util.Scanner;
import java.util.HashMap;
class Customer extends User{
	
	Customer(String userName,String password){
		super(userName,password);
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
		System.out.println("press 1 see all restaurant");
		System.out.println("press 2 see menu");
		System.out.println("press 3 to logout");
	    option=sc.nextInt();
		sc.nextLine();
		switch(option){
			case 1:
			
			HashMap<String,Restaurant> restaurants=rs.getRestaurants();
			
         for (Restaurant restaurant : restaurants.values()) {
                 System.out.println(restaurant.getName());
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