package com.example.customer;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class CustomerController {
	
	
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
	
	@RequestMapping(method= RequestMethod.GET, value="/customers/{longi}/{lat}")
	public GoogleResponse geocoding(@PathVariable String longi, String lat) throws IOException{
		
		 
		return customerService.geocoding(longi,lat);
		
	}
	
	

}
