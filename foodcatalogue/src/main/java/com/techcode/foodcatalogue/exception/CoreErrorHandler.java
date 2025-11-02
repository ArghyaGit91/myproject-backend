package com.techcode.foodcatalogue.exception;

public class CoreErrorHandler {
    public static void handleDataNotFoundException(ErrorResponse errorResponse){
        throw new DataNotFoundException(errorResponse);
    }
}
