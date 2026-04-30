abstract class User{
	private int userId;
	private String userName;
	private String password;
	protected User(int userId,String userName,String password){
		
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		System.out.println("User created");
		
	}
	protected boolean validateLogin(String userName,String password){
		 boolean isAuthenticate = this.userName.equals(userName) && this.password.equals(password);

        return isAuthenticate;
	}
	
	public abstract void showMenu(Theater theater);
	
	
	
}