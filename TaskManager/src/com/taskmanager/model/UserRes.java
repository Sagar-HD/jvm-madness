package com.taskmanager.model;

public class UserRes {
	private int id;
	private String name;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String email;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String password;
	
	public UserRes(int id,String email, String name) {
		super();
		this.id=id;
		this.email = email;
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	

}
