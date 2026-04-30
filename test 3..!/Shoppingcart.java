import java.util.ArrayList;
class Shoppingcart{
	
	int cartId;
	String customerName;
	ArrayList<Item> items=new ArrayList<>();
	double totalAmount=0;
	
	Shoppingcart(int cartId,String customerName){
		this.cartId=cartId;
		this.customerName=customerName;
		
		
	}
	
	void addProductToCart(Product product,int quantity){
		
		
		if(quantity>=10){
			double price=product.addToCart(quantity,true);
			if(price==-2){
				System.out.println("bulky order greater than 20 .. cant process");
				return;
			}
			else if(price ==-1){
				System.out.println("quantity out of stock....");
				return;
			}
			else{
				System.out.println("item added to cart ... quantity :"+quantity);
				if(quantity>=10){
				Item item=new Item(product.productName,quantity,product.price,product.discountPercentage+5);
				items.add(item);
				}
				else{
				
					Item item=new Item(product.productName,quantity,product.price,product.discountPercentage+5);
					items.add(item);
				}
				
				this.totalAmount+=price;
			}
		
		}
		else{
			double price=product.addToCart(quantity,false);
			
			 if(price ==-1){
				System.out.println("quantity out of stock....");
				return;
			}
			else{
				System.out.println("item added to cart ... quantity :"+quantity);
				if(quantity>=10){
				Item item=new Item(product.productName,quantity,product.price,product.discountPercentage+5);
				items.add(item);
				}
				else{
				
					Item item=new Item(product.productName,quantity,product.price,product.discountPercentage+5);
					items.add(item);
				}
				this.totalAmount+=price;
			}
		
		}
	}
	
	void generateBill(){
		System.out.println("bill-------------------");
		System.out.println("customerName :"+this.customerName);
        System.out.println("cart id :"+this.cartId);
		for(Item item : items ){
			System.out.println("ProductName :"+item.productName);
			System.out.println("quantity :"+item.productQuantity);
			System.out.println("unit price :"+item.unitPrice);
			System.out.println("discount applied :"+item.discountApplied);
			
			System.out.println("-------------------");
			
			
		}
	  System.out.println("total amount:"+this.totalAmount);
		
	}
	
	
	
}