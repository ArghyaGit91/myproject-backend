//package com.techcode.foodcatalogue.client.feignclientinfra;
//
//
//import com.techcode.foodcatalogue.client.fallbackfactory.RestaurantClientFallbackFactory;
//import com.techcode.foodcatalogue.dto.Restaurant;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(
//        name = "RESTAURANT-SERVICE",  // Service name registered in Eureka
//        path = "/restaurant",
//        fallbackFactory = RestaurantClientFallbackFactory.class
//)
//public interface RestaurantClient {
//
//    @GetMapping("/api/fetchRestaurant/{restaurantId}")
//    Restaurant getRestaurantById(@PathVariable("restaurantId") Integer restaurantId);
//}
