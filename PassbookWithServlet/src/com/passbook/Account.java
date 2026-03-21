package com.passbook;


public class Account{
	private String name;
	private long accountNumber;
	private String password;
	private double balance=0;
	
	
	public Account(long accountNumber,String name,String password){
		if(accountNumber<1000000000){
			System.out.println("invalid account number:");
			 throw new IllegalArgumentException("account number should be of 10 digits");
		}
		this.accountNumber=accountNumber;
		this.name=name;
		this.password=password;
	
	}
	public Account(long accountNumber,String name){
		if(accountNumber<1000000000){
			System.out.println("invalid account number:");
			 throw new IllegalArgumentException("account number should be of 10 digits");
		}
		this.accountNumber=accountNumber;
		this.name=name;
		
	
	}
	public String getName(){
		return this.name;
	}
	public long getAccountNumber(){
		return this.accountNumber;
	}
	public String getPassword(){
		return this.password;
	}
	public double getBalance(){
		return this.balance;
	}
	
	
	
	
	


	
	
}