class ProductRunner{
	
	public static void main(String... args){
		
		Product shoe=new Product(1,"shoe",500,20,"puma",10);
		Product pant=new Product(2,"pant",500,10,"puma",10);
		Shoppingcart shoppingCart=new Shoppingcart(1,"sagar");
		shoppingCart.addProductToCart(shoe,5);
		shoppingCart.addProductToCart(shoe,22);
		shoppingCart.addProductToCart(shoe,6);
		shoppingCart.addProductToCart(shoe,9);
		shoppingCart.addProductToCart(shoe,3);
		shoppingCart.addProductToCart(pant,2);
		shoppingCart.generateBill();
	}
	
	
	
}