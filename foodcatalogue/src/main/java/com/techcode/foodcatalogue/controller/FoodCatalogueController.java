package com.techcode.foodcatalogue.controller;


import com.techcode.foodcatalogue.bl.FoodCatalogueBL;
import com.techcode.foodcatalogue.dto.FoodItemDTO;
import com.techcode.foodcatalogue.ui.response.BaseUIResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogueBL foodCatalogueBL;

    @PostMapping(value = "/api/addFoodItem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseUIResponse> getAllRestaurants(@RequestBody @Valid FoodItemDTO foodItemDTO){

        BaseUIResponse response = foodCatalogueBL.saveFoodItem(foodItemDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
