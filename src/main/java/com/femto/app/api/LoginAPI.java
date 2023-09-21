package com.femto.app.api;

public class LoginAPI {
	
    private int id;
	private String phonenumber;
	private String name;
	private String address;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "{\n message: User registered successfully \n payload: phonenumber= " + phonenumber + ", name= " + name + ", address= " + address + " \n }";
	} 
}
