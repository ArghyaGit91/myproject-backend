package com.techcode.foodcatalogue.mapper;


import com.techcode.foodcatalogue.dto.FoodItemDTO;
import com.techcode.foodcatalogue.entity.FoodItemEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FoodItemMapper {

    FoodItemEntity mapFoodItemDtoToFoodItemEntity(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemEntityToFoodItemDTO(FoodItemEntity foodItemEntity);
}
