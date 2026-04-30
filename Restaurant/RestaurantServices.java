import java.util.HashMap;
class RestaurantServices{
	
	
	private HashMap<String,Restaurant> restaurants=new HashMap<>();
	private HashMap<String,Customer> customers=new HashMap<>();
	private User loggedInuser;
	private Admin admin;
	RestaurantServices(){
		
		this.admin=new Admin("sagar","sagarhd");
		
		
	}
		public boolean customerLogin(String name,String password){
		Customer customerToLogin=customers.get(name);
		if(customerToLogin!=null){
		if(customerToLogin.validate(name,password)==true){
			this.loggedInuser=customerToLogin;
			return true;
		}
		else{
			return false;
		}
		}
		else{
			return false;
		}
		
	}
	public User getLoggedInUser(){
		return this.loggedInuser;
	}
	public void logoutUser(){
        this.loggedInuser=null;
	}
	
	public void registerCustomer(String name,String password){
		Customer newCustomer=new Customer(name,password);
		customers.put(name,newCustomer);
		System.out.println("Customer registered");
		
	}
	public boolean adminLogin(String name,String password){
		if(this.admin.validate(name,password)==true){
			this.loggedInuser=this.admin;
			return true;
		}
		else{
			return false;
		}
		
	}

	public boolean  addRestaurant(Restaurant restaurantToAdd,String restaurantName){
		this.restaurants.put(restaurantName,restaurantToAdd);
		return true;
		
		
	}
	public boolean  removeRestaurant(String restaurantName){
		this.restaurants.remove(restaurantName);
		return true;
		
		
	}
	public Restaurant getRestaurantByName(String name){
		
		
		return this.restaurants.get(name);
	}
	public HashMap<String,Restaurant> getRestaurants(){
		
		
		return this.restaurants;
	}
	
	
	
}