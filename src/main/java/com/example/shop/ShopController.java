package com.example.shop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ShopController {
	
	public static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	
	
	
	public ShopController() {
		super();
		
	}
	

	public ShopController(ShopService shopService) {
		super();
		this.shopService = shopService;
	}



	



	@Autowired
	public ShopService shopService;
	
	@RequestMapping("/shops")
	public List<Shop> getAllShop(){
		
		return shopService.getAllShop();
		
		
		
	}
	
	@RequestMapping("/shops/{id}")
	public Shop getShop(@PathVariable int id){
		
		
		return shopService.getShop(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/shops")
	public void addShop(@RequestBody Shop s){
		
		logger.info("Creating shop : {}", s);
		shopService.addShop(s);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/shops/{id}")
	public void updateShop(@PathVariable int id, @RequestBody Shop shop){
		
		logger.info("updating shop : {}", id);
		shopService.updateShop(id,shop);
	}

	@RequestMapping(method= RequestMethod.DELETE, value="/shops/{id}")
	public void deleteShop(@PathVariable int id){
		
		logger.info("deleting shop : {}", id);
		shopService.deleteShop(id);
	}
	
	
}
