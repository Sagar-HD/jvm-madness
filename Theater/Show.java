import java.util.HashMap;

class Show implements Bookable{
	
	private final int fixedPrice=250;
	private final int seatsPerRow=10;
	private String showName;
	private int availableSeats;
	private int totalSeats;
	private HashMap<Integer,Seat> seats=new HashMap<>();
	Show(String showName,int totalSeats){
		
		
		this.showName=showName;
		this.availableSeats=totalSeats;
		this.totalSeats=totalSeats;
		  for(int i = 1; i <= totalSeats; i++) {
			int row = (i - 1) / seatsPerRow + 1;
        seats.put(i, new Seat(i,fixedPrice+((row-1)*20) ));
    }
  
	}
	public int getAvailableSeats(){
	  return this.availableSeats;
  }
	public int getTotalSeats(){
	  return this.totalSeats;
  }
  @Override
public void book(int seatNo){
	
		Seat seatToBook=seats.get(seatNo);
		if(seatToBook.getAvailability()){
	   seatToBook.setAvailability(false);
	  System.out.println("Seat Booked");
	  this.availableSeats-=1;
		}
		else{
		 System.out.println("Seat Not available");	
		}
}
@Override
public void cancel(int seatNo){

   Seat seatToCancel=seats.get(seatNo);
   	if(!seatToCancel.getAvailability()){
	   seatToCancel.setAvailability(true);
	  System.out.println("Seat Canceled");
	 this.availableSeats+=1;
	}
	else{
		 System.out.println("Seat is not booked to cancel");
	}
}
public HashMap<Integer,Seat> getSeats(){
	
	return this.seats;
}
	
}