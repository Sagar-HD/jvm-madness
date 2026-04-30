class Product{
	int productId;
	String productName;
	double price;
	int quantityAvailable;
	String category;
	int discountPercentage;
	
	
	Product(int productId,String productName,int price,int quantityAvailable,String category,int discountPercentage){
		
		this.productId=productId;
		this.productName=productName;
		this.price=price;
		this.quantityAvailable=quantityAvailable;
		this.category=category;
		this.discountPercentage=discountPercentage;
		
	}
	void getDetails(){
		System.out.println("productId :"+productId);
		System.out.println("productName :"+productName);
		System.out.println("price :"+price);
		System.out.println("quantityAvailable :"+quantityAvailable);
		System.out.println("category :"+category);
		System.out.println("discountPercentage :"+discountPercentage);
	}
	double calculateDiscountPrice(int quantity,int discountPercentage){
		return (this.price*quantity)-((this.price*quantity)*(discountPercentage/100));
	}
	double addToCart(int quantity){
		if(this.quantityAvailable>=quantity){
			this.quantityAvailable-=quantity;
			
			return calculateDiscountPrice(quantity,this.discountPercentage);
			
		}
		else{
			
			return -1;
		}
	}
	double addToCart(int quantity,boolean isBulk){
		if(isBulk){
			if(quantity>=20){
				
				return -2;
			}
			else if(quantity>=10 ){
				if(this.quantityAvailable>=quantity){
				this.quantityAvailable-=quantity;
				
				return calculateDiscountPrice(quantity,this.discountPercentage+5);
				}
			else{
			
			return -1;
		}
				
			}
			return addToCart(quantity);
			
			
		}
		else{
			return addToCart(quantity);
		}
		
	}
	
	
}