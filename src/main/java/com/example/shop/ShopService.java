package com.example.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.Errors.DataNotFoundException;




@Service
public class ShopService {
	
	public static final Logger logger = LoggerFactory.getLogger(ShopService.class);
	
	
	public ShopService(List<Shop> shops) {
		super();
		this.shops = shops;
	}

	
	public ShopService() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Shop> shops = new ArrayList<>(Arrays.asList(
			new Shop(1,"shop1",(new ShopAddress(1,"111111")),141.4567,234.678),
			new Shop(2,"shop2",(new ShopAddress(2,"222222")),1234.5678,345.678),
			new Shop(3,"shop3",(new ShopAddress(3,"333333")),4567.765456,567.7654),
			new Shop(4,"shop4",(new ShopAddress(1,"123456")),54545.67543,4567876.67865)
			));

	public List<Shop> getAllShop() {
		
		
		return shops;
	}

	public Shop getShop(int id) {
		
		Shop s1 = shops.get(id);
		
		for(int i=0;i<shops.size();i++){
			
			   Shop s = shops.get(i);
			   
			   if(s.getId() == id){
				   
				Shop shop = shops.get(i);
				
				if(shop == null)
				{
					
					throw new DataNotFoundException("Shop with id"+ id+" Not Found");
				}
				return shop;
				   
			   }   
			   
		}
		return null ;
		
	}
	
	public void addShop(Shop s) {
		
		
		shops.add(s);
		
		
	}
	

	public void updateShop(int id, Shop shop) {
		
		if(shops.isEmpty()){
			
			throw new DataNotFoundException("Shop Not Found");
		}
		
		else{
		
		for(int i=0;i<shops.size();i++){
			
			   Shop s = shops.get(i);
			   
			   if(s.getId() == id){
				   
				shops.set(i, shop);
				   
			   }  
		
		}
		}
	}

	public void deleteShop(int id) {
		
		
		if(shops.isEmpty()){
			
			throw new DataNotFoundException("Shop Not Found");
		}
		
		else{
		
		for(int i=0;i<shops.size();i++){
			
			   Shop s = shops.get(i);
			   
			   if(s.getId() == id){
				   
				shops.remove(i);
				   
			   } 
		}
		}
	
	}

	

	
}
