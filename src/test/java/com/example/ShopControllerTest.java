package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.shop.Shop;
import com.example.shop.ShopAddress;
import com.example.shop.ShopController;
import com.example.shop.ShopService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Shop.class,ShopController.class,ShopService.class})
@SpringBootTest

public class ShopControllerTest {
	
	
	private ShopController shopController = new ShopController();
	
	
	private ShopService shopService;
	
	
	private Shop s1,s2,s3,s4;
	

	
	@Before
	public void initalizeMockito(){
		
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void getAllShop() {
		
		
	
	
		 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress1"));
		 s2 = new Shop(2,"TestShop2",new ShopAddress(102,"TestAddress2"));
		 s3 = new Shop(3,"TestShop3",new ShopAddress(103,"TestAddress3"));
		
		 
		 List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
		 l1.add(s3);
		 
		 shopService = new ShopService(l1);
		 
		
		shopController = new ShopController(shopService);
		
		shopController.getAllShop();
		
		assertEquals(l1,shopController.getAllShop());
		
				 
				
	}
	
    @Test
	public void getShop() {
    	
		
    	//shopService = mock(ShopService.class);
		 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s2 = new Shop(2,"TestShop1",new ShopAddress(101,"TestAddress"));
		 
		List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
				 
		shopService = new ShopService(l1);
		 
		
		shopController = new ShopController(shopService);
		
		shopController.getShop(1);
				
				
		assertEquals(s1,shopController.getShop(1));
		
				
		
		
	}
    
   @Test
  	public void addShop() {
      	
  		
      //	shopService = mock(ShopService.class);
      	
      	 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress1"));
		 s2 = new Shop(2,"TestShop1",new ShopAddress(102,"TestAddress2"));
		 
		List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
  		 s3 = new Shop(3,"TestShop3",new ShopAddress(103,"TestAddress3"));
  		
  		 	 
  		shopService = new ShopService(l1);
  		 
  		
  		shopController = new ShopController(shopService);
  		
  		shopController.addShop(s3);
  		
  	       Assert.assertNotNull(s3);
  		
  		
  		
  		  	}
   
   
   @Test
 	public void updateShop() {
     	
 		
     //	shopService = mock(ShopService.class);
     	
     	 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s2 = new Shop(2,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s3 = new Shop(3,"TestShop3",new ShopAddress(103,"TestAddress"));
		 
		List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
		 l1.add(s3);
 		 s4 = new Shop(1,"TestShop4",new ShopAddress(104,"TestAddress4"));
 		
 		 	 
 		shopService = new ShopService(l1);
 		 
 		
 		shopController = new ShopController(shopService);
 		
 		shopController.updateShop(1,s4);
 		
 	
 		
 		Assert.assertEquals(s4, shopController.getShop(1));
 		
 		
 		  	}
    
    @Test
  	public void deleteShop() {
      	
  		
      	//shopService = mock(ShopService.class);
      	
      	 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s2 = new Shop(2,"TestShop2",new ShopAddress(102,"TestAddress"));
		 s3 = new Shop(3,"TestShop3",new ShopAddress(103,"TestAddress"));
		 
		List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
		 l1.add(s3);
  			
  		  
  		shopService = new ShopService(l1);
  		 
  		
  		shopController = new ShopController(shopService);
  		
  		shopController.deleteShop(1);
  		
  		Assert.assertNull(shopController.getShop(1));
  		
  						
  		
  		
  	}
    
    
    
 
}
