package com.example.customer;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.example.shop.Shop;
//import com.example.shop.ShopAddress;




@RestController
public class CustomerController {
	
	Customer customer;
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomer(){
		
		return customerService.getAllCustomer();
		
		
		
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id){
		
		
		return customerService.getCustomer(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public void addCustomer(@RequestBody Customer c){
		
		
		customerService.addCustomer(c);
	}
	
	/*@RequestMapping(method= RequestMethod.GET, value="/customers/{longi}/{lat}")
	public GoogleResponse geocoding(@PathVariable String longi, String lat) throws IOException{
		
		 
		return customerService.geocoding(longi,lat);
		
	}*/
	@RequestMapping(value = "/customer/shop/{address}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getLongitudeandLatitude(@PathVariable String address) throws Exception {
		
		//String address=shop.getShopaddress();
		//String address = shop.getAddress().toString();
		geocoding(address);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	

	private void geocoding(String address) throws Exception
	{
	    // build a URL
	    //String s = "http://maps.google.com/maps/api/geocode/json?" +
	                  //  "sensor=false&address=";
		
		String s = "https://maps.googleapis.com/maps/api/geocode/json?"+ "sensor=false&address=";
	    s += URLEncoder.encode(address, "UTF-8");
	    
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    if (! obj.getString("status").equals("OK"))
	        return;
	 
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    System.out.println(res.getString("formatted_address"));
	    JSONObject loc =
	        res.getJSONObject("geometry").getJSONObject("location");
	    System.out.println("lat: " + loc.getDouble("lat") +
	                        ", lng: " + loc.getDouble("lng"));
	}
	
	

}
