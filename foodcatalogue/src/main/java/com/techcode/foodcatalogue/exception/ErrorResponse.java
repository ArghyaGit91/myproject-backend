package com.techcode.foodcatalogue.exception;

import com.techcode.foodcatalogue.util.ErrorMessgeEnum;
import org.apache.http.util.TextUtils;


public class ErrorResponse {
    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorResponse getNewError(ErrorMessgeEnum errorMessgeEnum, String detailedErrorMessage){
        String errorMessageEnumName = errorMessgeEnum.name();
        String errorCode = errorMessageEnumName.substring(
                errorMessgeEnum.name().lastIndexOf('_')+1);
        String errorMessage = errorMessgeEnum.getCustomMessage();
        if (TextUtils.isEmpty(detailedErrorMessage)){
            errorMessage = new StringBuilder(errorMessage).append(detailedErrorMessage).toString();
        }
        return new ErrorResponse(errorCode, errorMessage);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
