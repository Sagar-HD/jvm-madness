abstract class User{
	
	private String name;
	private String password;
	User(String name,String password){
		this.name=name;
		this.password=password;
	}
	 protected String getName(){
        return name;
    }

    protected String getPassword(){
        return password;
    }
	public abstract boolean  validate(String name,String password);
    public abstract void showOptions(RestaurantServices rs);
}