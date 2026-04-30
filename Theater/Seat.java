class Seat{
	
	private boolean isAvailable;
	private int seatNumber;
	private int price;
	
	Seat(int seatNumber,int price){
		this.isAvailable=true;
		this.seatNumber=seatNumber;
		this.price=price;
	}
   public void setAvailability(boolean value){
	   this.isAvailable=value;
   }
  public boolean getAvailability(){
	  return this.isAvailable;
   }

	
	
}