package com.example.customer;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.LatLong;
import com.fasterxml.jackson.databind.ObjectMapper;


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
	
		
	@RequestMapping(value = "/customer/shop/{address}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response getLongitudeandLatitude(@PathVariable String address) throws Exception {
	
	    // build a URL
		
		String s = "https://maps.googleapis.com/maps/api/geocode/json?"+ "sensor=false&address=";
	    s += URLEncoder.encode(address, "UTF-8");
	    
	    URL url = new URL(s);
	    List<LatLong> list = new ArrayList<LatLong>();
	    //JSONArray jsonArr = new JSONArray(response);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    if (! obj.getString("status").equals("OK"))
	        return null;
	 
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    String resident = res.getString("formatted_address");
	   // LatLong re = (LatLong) new String("resident");
	    System.out.println(resident);
	    JSONObject loc =
	        res.getJSONObject("geometry").getJSONObject("location");
	    ObjectMapper mapper = new ObjectMapper();
	    LatLong latlong = mapper.readValue(loc.toString(),LatLong.class); 
	    
	   
	    list.add(latlong);
	    double lat = loc.getDouble("lat");
	    double lng = loc.getDouble("lng");
	    
	    System.out.println("lat: " + lat +
	                        ", lng: " + lng);
	    
	    System.out.println("The LOC is"+loc);
	    
	     return Response.status(200).entity(latlong).build();
	     
	  
	}
	
	

}
