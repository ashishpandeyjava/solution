package com.example.shop;

public class Shop {
	
	private int id;
	private String shopName;
	private ShopAddress address;
	private double shopLongitude;
	private double shopLatitude;
	
	
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(int id, String shopName, ShopAddress address) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.address = address;
	}
	
	public Shop(double shopLongitude, double shopLatitude) {
		super();
		this.shopLongitude = shopLongitude;
		this.shopLatitude = shopLatitude;
	}
	
	
	public Shop(int id, String shopName, ShopAddress address, double shopLongitude, double shopLatitude) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.address = address;
		this.shopLongitude = shopLongitude;
		this.shopLatitude = shopLatitude;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public ShopAddress getAddress() {
		return address;
	}
	public void setAddress(ShopAddress address) {
		this.address = address;
	}
	public double getShopLongitude() {
		return shopLongitude;
	}
	public void setShopLongitude(long shopLongitude) {
		this.shopLongitude = shopLongitude;
	}
	public double getShopLatitude() {
		return shopLatitude;
	}
	public void setShopLatitude(long shopLatitude) {
		this.shopLatitude = shopLatitude;
	}
	
	

}
