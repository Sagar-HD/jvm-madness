import java.util.HashMap;

class Cart{
	
	private HashMap<MenuItem,Integer> cartItems = new HashMap<>;
	
	Cart(){
		
		this.cartItems=new HashMap<>;
		
	}
	public void addItemToCart(MenuItem menuItem,int quantity){
		this.cartItems.put(menuItem,quantity);
		System.out.println("item : "+menuItem.getName()+" added to cart");
	}
	public void clearCart(){
		this.cartItems.clear();
	}
	
}