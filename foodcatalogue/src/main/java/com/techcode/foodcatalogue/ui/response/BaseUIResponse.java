package com.techcode.foodcatalogue.ui.response;


import com.techcode.foodcatalogue.ui.ErrorDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseUIResponse {
    private String status = "SUCCESS";
    private boolean hasError;
    private ErrorDetails errorDetails = null;


}
