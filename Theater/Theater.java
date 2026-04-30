import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
class Theater{
	
	
	private final Admin admin=new Admin(1,"sagar","sagarhd");
	private HashMap<String,Customer> customers=new HashMap<>();
	private HashMap<String,Show> shows=new HashMap<>();
	static int noOfUsers=0;
	User loggedInUser=null;
 public void showMenu(){
	 boolean run=true;
	 while(run){
	 while(this.loggedInUser==null){
		 
	 Scanner scanner=new Scanner(System.in);
	int choice;
	
	System.out.println("press 1 to Login as Admin");
	System.out.println("press 2 to Login as Customer");
    System.out.println("press 3 to Register as Customer");
	 System.out.println("press 4 to exit");
	 
	choice=scanner.nextInt();
		scanner.nextLine();
	switch(choice){
		case 1:
		loginAdmin();
		break;
		case 2:
		loginCustomer();
		break;
		case 3:
		registerCustomer();
		break;
		case 4:
		return;
		default:
		System.out.println("invalid input");
	}

	 }
	 loggedInUser.showMenu(this);
	 }
}
	public void registerCustomer(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a user name");
		String userName=scanner.nextLine();
		System.out.println("enter a password");
		String password=scanner.nextLine();
		Customer customer=new Customer(Theater.noOfUsers+1,userName,password);
		customers.put(userName,customer);
		Theater.noOfUsers+=1;
		
	}
	public void loginCustomer(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a user name");
		String userName=scanner.nextLine();
		System.out.println("enter a password");
		String password=scanner.nextLine();
		Customer loginCustomer=customers.get(userName);
		if(loginCustomer==null){
			System.out.println("Invalid username or password not found");
			return;
		}
		if(loginCustomer.validateLogin(userName,password)==true){
		loggedInUser=loginCustomer;
		System.out.println("Customer logged in sucessfully");
		}
		else{
			System.out.println("Invalid username or password");
			return;
		}
		
	}
	public void loginAdmin(){
	Scanner scanner=new Scanner(System.in);
		System.out.println("enter a user name");
		String userName=scanner.nextLine();
		System.out.println("enter a password");
		String password=scanner.nextLine();
		
		
		if(this.admin.validateLogin(userName,password)!=true){
			System.out.println("Invalid username or password");
			return;
			
			
		}
		else{
			loggedInUser=this.admin;
		System.out.println("Admin logged in sucessfully");
		}
		
	}
	public void logout(){
		this.loggedInUser=null;
		
	}
	public void createShow(){
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter show name");
		String showName=scanner.nextLine();
		System.out.println("enter total seats");
		int totalSeats=scanner.nextInt();
		scanner.nextLine();
		Show showToAdd=new Show(showName,totalSeats);
		shows.put(showName,showToAdd);
		System.out.println("Show created successfully");
		
	}
	public void displayShows(){
		 if(shows.isEmpty()){
        System.out.println("No shows available");
        return;
    }

    for(Map.Entry<String, Show> entry : shows.entrySet()) {

        String showName = entry.getKey();
        

        System.out.println("Show name: " + showName);
       
        System.out.println("----------------------");
    }
	}
	public void bookSeat() throws seatNotAvailableException,showNotFoundException{
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter show name to book");
		String showName=scanner.nextLine();
		Show showToBook=shows.get(showName);
		if(showToBook==null){
			throw new showNotFoundException("seat not available");
		}
		if(showToBook.getAvailableSeats()<=0){
			throw new seatNotAvailableException("seat not available");
			
			
		}
		System.out.println("Show name : "+showName);
		System.out.println("Available Seats : "+showToBook.getAvailableSeats());
		
    boolean found = false;

    System.out.println("Available Seats:");

	HashMap<Integer,Seat> seats= showToBook.getSeats();
	//logic to displayavailable seats
    for(Map.Entry<Integer, Seat> entry : seats.entrySet()){

        Seat seat = entry.getValue();

        if(seat.getAvailability()){
            System.out.print(entry.getKey() + " ");
            found = true;
        }
    }

    if(!found){
        System.out.println("No seats available");
    }
    else{
        System.out.println();
    }
	//seat display logic
	    System.out.println("enter seat no to book");
		int seatNoToBook=scanner.nextInt();
		scanner.nextLine();
		showToBook.book(seatNoToBook);
		

	}
	public void cancelSeat() throws showNotFoundException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter show name to cancel");
		String showName=scanner.nextLine();
		Show showToCancel=shows.get(showName);
		if(showToCancel==null){
			throw new showNotFoundException("Show not found");
			
		}
		
		System.out.println("Show name : "+showName);
		
	    System.out.println("enter seat no to cancel");
		int seatNoToCancel=scanner.nextInt();
		scanner.nextLine();
		showToCancel.cancel(seatNoToCancel);
		

	}
}