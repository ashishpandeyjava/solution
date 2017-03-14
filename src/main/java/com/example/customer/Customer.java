package com.example.customer;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerLongitude;
	private String customerLatitude;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String customerLongitude, String customerLatitude) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerLongitude = customerLongitude;
		this.customerLatitude = customerLatitude;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerLongitude() {
		return customerLongitude;
	}
	public void setCustomerLongitude(String customerLongitude) {
		this.customerLongitude = customerLongitude;
	}
	public String getCustomerLatitude() {
		return customerLatitude;
	}
	public void setCustomerLatitude(String customerLatitude) {
		this.customerLatitude = customerLatitude;
	}
	
	
	
	
}
