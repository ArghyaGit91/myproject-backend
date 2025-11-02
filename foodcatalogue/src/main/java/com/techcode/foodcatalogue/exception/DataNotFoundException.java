package com.techcode.foodcatalogue.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class DataNotFoundException extends RuntimeException{

    private final String errorCode;
    private final String errorMessage;

    protected DataNotFoundException(ErrorResponse errorResponse){
        super(errorResponse.getMessage());
        this.errorCode = errorResponse.getCode();
        this.errorMessage = errorResponse.getMessage();

    }

}
