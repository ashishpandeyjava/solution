package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@InjectMocks
	public ShopController shopController = new ShopController();
	
	@Mock 
	public ShopService shopService;
	
	
	public Shop s1,s2,s3;
	

	
	@Before
	public void initalizeMockito(){
		
		MockitoAnnotations.initMocks(this);
		
	}

	@Test
	public void getAllShop() {
		
		
	
		shopService = mock(ShopService.class);
		 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s2 = new Shop(2,"TestShop2",new ShopAddress(101,"TestAddress"));
		 s3 = new Shop(3,"TestShop3",new ShopAddress(101,"TestAddress"));
		
		 
		 List<Shop> l1 = new ArrayList<Shop>();
		 
		 l1.add(s1);
		 l1.add(s2);
		 l1.add(s3);
		 
		 shopService = new ShopService(l1);
		 
		
		shopController = new ShopController(shopService);
		 //shopController.addShop(s1);
		//shopService.addShop(s);
		 
		//when (shopService.getAllShop()).thenReturn(l1);
		// when (shopController.getAllShop()).thenReturn(l1);
		
	}
	
    @Test
	public void getShop() {
    	
		
    	//shopService = mock(ShopService.class);
		 s1 = new Shop(1,"TestShop1",new ShopAddress(101,"TestAddress"));
		 s2 = new Shop(2,"TestShop1",new ShopAddress(101,"TestAddress"));
		 
		List<Shop> l1 = new ArrayList<Shop>(10);
		 
		 l1.add(s1);
		 l1.add(s2);
				 
		shopService = new ShopService(l1);
		 
		
		shopController = new ShopController(shopService);
		
				
		when (shopService.getShop(anyInt())).thenReturn(s1);
		
	//when (shopController.getShop(anyInt())).thenReturn(s1);
		
		
		
		
	}
    
 
}
