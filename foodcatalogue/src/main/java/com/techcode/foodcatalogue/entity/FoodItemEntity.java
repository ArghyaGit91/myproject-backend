package com.techcode.foodcatalogue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemEntity {
    @Id
    @Column(length = 36)
    private String itemId;

    private String itemName;

    private String itemDescription;

    @Column(name = "is_veg")
    private boolean veg;

    private Integer restaurantId;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

    @PrePersist
    public void generateId() {
        if (itemId == null) {
            itemId = UUID.randomUUID().toString();  // UUID as String
        }
    }
}
