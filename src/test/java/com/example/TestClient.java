package com.example;


import org.springframework.web.client.RestTemplate;

import com.example.shop.Shop;
import com.example.shop.ShopAddress;


public class TestClient {



    public static final String REST_SERVICE_URI = "http://localhost:8080";
     
       /* GET */
    private static void getShop(){
        System.out.println("Testing get Shop API----------");
        RestTemplate restTemplate = new RestTemplate();
        Shop shop = (Shop) restTemplate.getForObject(REST_SERVICE_URI+"/shops/1", Shop.class);
        System.out.println(shop);
    }
     
    /* POST */
    private static void addShop() {
        System.out.println("Testing create Shop API----------");
        RestTemplate restTemplate = new RestTemplate();
        Shop shop = new Shop(1,"shop1",(new ShopAddress(1,"111111")),141.4567,234.678);
        restTemplate.postForObject(REST_SERVICE_URI+"/shops/", shop, Shop.class);
        
    }
 
    /* PUT */
    private static void updateShop() {
        System.out.println("Testing update Shop API----------");
        RestTemplate restTemplate = new RestTemplate();
        Shop shop = new Shop(1,"shop11",(new ShopAddress(1,"11111122")),141.4567,234.678);
        restTemplate.put(REST_SERVICE_URI+"/shops/1", shop,Shop.class);
        System.out.println(shop);
    }
 
    /* DELETE */
    private static void deleteShop() {
        System.out.println("Testing delete Shop API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/shops/3",Shop.class);
    }
 
 
     
    public static void main(String args[]){
    	
        getShop();
        addShop();
     
        updateShop();
       
        deleteShop();
       
    }
}