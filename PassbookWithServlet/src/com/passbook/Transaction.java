package com.passbook;

import java.time.LocalDateTime;

public class Transaction{
	
	private long accountNumber;
	private String type;
	private double amount;
	private LocalDateTime dateTime;
	public Transaction(long accountNumber,String type,double amount){
		this.accountNumber=accountNumber;
		this.type=type;
		this.amount=amount;
	}
	public Transaction(long accountNumber,String type,double amount,LocalDateTime dateTime){
		this.accountNumber=accountNumber;
		this.type=type;
		this.amount=amount;
		this.dateTime=dateTime;
	}
	public long getAccountNumber(){
		return this.accountNumber;
	}
	public String getType(){
		return this.type;
	}
	public double getAmount(){
		return this.amount;
	}
	public LocalDateTime getDateTime(){
		return this.dateTime;
	}
}
