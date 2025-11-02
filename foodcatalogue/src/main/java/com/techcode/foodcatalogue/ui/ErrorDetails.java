package com.techcode.foodcatalogue.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String code;
    private String message;
    private String extendedMessage;


}
