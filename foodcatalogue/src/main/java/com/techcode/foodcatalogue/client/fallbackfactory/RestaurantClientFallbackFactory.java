//package com.techcode.foodcatalogue.client.fallbackfactory;
//
//
//import com.techcode.foodcatalogue.client.GenericFallbackFactory;
//import com.techcode.foodcatalogue.client.feignclientinfra.RestaurantClient;
//import com.techcode.foodcatalogue.dto.Restaurant;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RestaurantClientFallbackFactory extends GenericFallbackFactory<RestaurantClient> {
//
//
//    @Override
//    protected RestaurantClient createFallback(Throwable cause) {
//        return restaurantId -> {
//            Restaurant fallback = new Restaurant();
//            fallback.setId(0);
//            fallback.setRestaurantName("Unavailable Restaurant");
//            fallback.setAddress("N/A");
//            fallback.setCity("N/A");
//            fallback.setDescription("Fallback triggered due to service unavailability: " + cause.getMessage());
//            return fallback;
//        };
//    }
//}
