package com.techcode.foodcatalogue.repository;

import com.techcode.foodcatalogue.entity.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemEntity, String> {

    @Query(value = "select * from food_item_entity fie where fie.restaurant_id = :restaurantId",nativeQuery = true)
    Optional<List<FoodItemEntity>> findByRestaurantId(Integer restaurantId);
}
