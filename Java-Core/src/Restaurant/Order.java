import java.util.List;
class Order{
	
	private int orderId;
	private List<MenuItem> orderItems;
	private boolean status;
	
	
	Order(int orderId,List<MenuItem> orderItems){
		
		this.orderId=orderId;
		this.orderItems=orderItems;
		this.status=false;
		
	}
	
	
	public void placeOrder(){
		this.status=true;
	}
	
	
	
}