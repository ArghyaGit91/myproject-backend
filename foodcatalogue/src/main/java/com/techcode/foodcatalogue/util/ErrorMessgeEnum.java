package com.techcode.foodcatalogue.util;


public enum ErrorMessgeEnum {
    CLIENT_ERROR_DATA_NOT_FOUND("No data found");
    private String customMessage;

    ErrorMessgeEnum(String customMessage) {
        this.customMessage = customMessage;
    }

    public String getCustomMessage() {
        return customMessage;
    }
}
