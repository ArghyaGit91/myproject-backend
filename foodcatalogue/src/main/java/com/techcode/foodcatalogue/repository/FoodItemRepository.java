package com.techcode.foodcatalogue.repository;

import com.techcode.foodcatalogue.entity.FoodItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemEntity, String> {
}
