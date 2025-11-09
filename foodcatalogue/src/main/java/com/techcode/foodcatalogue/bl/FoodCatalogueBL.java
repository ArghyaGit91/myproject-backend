package com.techcode.foodcatalogue.bl;


import com.google.gson.Gson;
//import com.techcode.foodcatalogue.client.feignclientinfra.RestaurantClient;
import com.techcode.foodcatalogue.dto.FoodCataloguePage;
import com.techcode.foodcatalogue.dto.FoodItemDTO;
import com.techcode.foodcatalogue.dto.Restaurant;
import com.techcode.foodcatalogue.entity.FoodItemEntity;
import com.techcode.foodcatalogue.mapper.FoodItemMapper;
import com.techcode.foodcatalogue.service.FoodItemService;
import com.techcode.foodcatalogue.service.GenericFeignService;
import com.techcode.foodcatalogue.ui.response.BaseUIResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
@RefreshScope
public class FoodCatalogueBL {

    @Autowired
    private FoodItemMapper foodItemMapper;

    @Autowired
    private FoodItemService foodItemService;

//    @Autowired
//    private RestaurantClient restaurantClient;

    @Autowired
    private GenericFeignService genericFeignService;


    public BaseUIResponse saveFoodItem(@Valid FoodItemDTO foodItemDTO) {
        FoodItemEntity foodItemEntity = foodItemService.saveFoodItem(
                foodItemMapper.mapFoodItemDtoToFoodItemEntity(foodItemDTO)
        );
//        BaseUIResponse response = new BaseUIResponse();
        if (foodItemEntity!= null){

            return new BaseUIResponse();
        }
        return null;
    }

//    public FoodCataloguePage fetchRestaurantDetailsWithFoodMenu(Integer restaurantId) {
//
//        // Step 1: Fetch restaurant details from RestaurantListing microservice (via Feign)
//        Restaurant restaurant = restaurantClient.getRestaurantById(restaurantId);
//        Gson gson = new Gson();
//        String restaurantJson = gson.toJson(restaurant);
//        log.info("Restaurant JSON: {}", restaurantJson);
//
//        // Step 2: Fetch all food items belonging to that restaurant from local DB
//        Optional<List<FoodItemEntity>> foodItemsEntityList = foodItemService.findByRestaurantId(restaurantId);
//
//        List<FoodItemDTO> foodDTOs = null;
//        if (foodItemsEntityList.isPresent()) {
//            foodDTOs = foodItemMapper.mapFoodItemEntityListToDTOList(foodItemsEntityList.get());
//        }
//        log.info("Restaurant JSON: Size: {}",foodDTOs.size());
//        // Step 3: Combine both into a single DTO
//        FoodCataloguePage page = new FoodCataloguePage();  // ← HERE
//        page.setRestaurant(restaurant);
//        page.setFoodItemsList(foodDTOs);
//
//        return page;
//    }


    public FoodCataloguePage fetchRestaurantDetailsWithFoodMenu(Integer restaurantId) {


        String baseUrl = "http://localhost:9091";
        String path = "/restaurant/api/fetchRestaurant/" + restaurantId;

        String fullUrl = baseUrl + path;

        log.info("Calling external microservice: {}", fullUrl);

        Object response = genericFeignService.getFromService(baseUrl, path, Map.of());
        Gson gson = new Gson();

        // Deserialize generic Object to your Restaurant class
        Restaurant restaurant = gson.fromJson(gson.toJson(response), Restaurant.class);
        log.info("Fetched Restaurant JSON: {}", gson.toJson(restaurant));

        // Step 2️⃣: Fetch food items from local DB
        Optional<List<FoodItemEntity>> foodItemsEntityList = foodItemService.findByRestaurantId(restaurantId);
        List<FoodItemDTO> foodDTOs = new ArrayList<>();

        if (foodItemsEntityList.isPresent()) {
            foodDTOs = foodItemMapper.mapFoodItemEntityListToDTOList(foodItemsEntityList.get());
        }
        log.info("Fetched {} food items for restaurant {}", foodDTOs.size(), restaurantId);

        // Step 3️⃣: Combine restaurant + food list into a response page
        FoodCataloguePage page = new FoodCataloguePage();
        page.setRestaurant(restaurant);
        page.setFoodItemsList(foodDTOs);

        return page;
    }



}
