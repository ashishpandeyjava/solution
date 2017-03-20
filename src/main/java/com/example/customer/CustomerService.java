package com.example.customer;

import java.io.IOException;
import java.io.InputStream;


import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.example.Errors.DataNotFoundException;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

//import net.minidev.json.JSONObject;





@Service
public class CustomerService {
	
	final String URL = "http://maps.googleapis.com/maps/api/geocode/json";
	
	private List<Customer> customers = new ArrayList<>(Arrays.asList(
			new Customer(1,"customer1","141.4567","234.678"),
			new Customer(2,"customer2","1234.5678","345.678"),
			new Customer(3,"customer3","4567.765456","567.7654"),
			new Customer(4,"customer3","54545.67543","4567876.67865")
			));

	public List<Customer> getAllCustomer() {
	
		return customers;
	}

	public void addCustomer(Customer c) {
		
		customers.add(c);
		
	}

	public Customer getCustomer(int id) {
		
Customer c1 = customers.get(id);
		
		for(int i=0;i<customers.size();i++){
			
			Customer c = customers.get(i);
			   
			   if(c.getCustomerId() == id){
				   
				Customer cust = customers.get(i);
				
				if(cust == null)
				{
					
					throw new DataNotFoundException("Shop with id"+ id+" Not Found");
				}
				return cust;
				   
			   }   
			   
		}
		return c1 ;

	}
	
	
}
