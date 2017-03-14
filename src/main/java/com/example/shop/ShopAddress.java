package com.example.shop;

public class ShopAddress {
	
	private int number;
	private String postcode;
	
	
	
	public ShopAddress() {
		super();
	
	}
	
	
	public ShopAddress(int number, String postcode) {
		super();
		this.number = number;
		this.postcode = postcode;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	
	
	
	

}
