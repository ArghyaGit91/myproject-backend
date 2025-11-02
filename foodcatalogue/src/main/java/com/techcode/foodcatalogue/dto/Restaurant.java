package com.techcode.foodcatalogue.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private Integer id;
    private String restaurantName;
    private String address;
    private String city;
    private String description;
}
