package com.techcode.foodcatalogue.service;


import com.techcode.foodcatalogue.entity.FoodItemEntity;
import com.techcode.foodcatalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItemEntity saveFoodItem(FoodItemEntity foodItemEntity) {
        return foodItemRepository.saveAndFlush(foodItemEntity);
    }
}
