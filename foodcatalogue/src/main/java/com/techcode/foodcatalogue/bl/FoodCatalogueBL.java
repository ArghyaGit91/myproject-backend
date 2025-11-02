package com.techcode.foodcatalogue.bl;


import com.techcode.foodcatalogue.dto.FoodItemDTO;
import com.techcode.foodcatalogue.entity.FoodItemEntity;
import com.techcode.foodcatalogue.mapper.FoodItemMapper;
import com.techcode.foodcatalogue.service.FoodItemService;
import com.techcode.foodcatalogue.ui.response.BaseUIResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RefreshScope
public class FoodCatalogueBL {

    @Autowired
    private FoodItemMapper foodItemMapper;

    @Autowired
    private FoodItemService foodItemService;


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
}
