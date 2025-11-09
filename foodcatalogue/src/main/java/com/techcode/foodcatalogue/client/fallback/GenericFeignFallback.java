package com.techcode.foodcatalogue.client.fallback;


import com.techcode.foodcatalogue.client.feignclientinfra.GenericFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class GenericFeignFallback implements GenericFeignClient {
    @Override
    public Object getRequest(String fullPath) {
        log.error("Fallback triggered for GET request to {}", fullPath);
        return defaultResponse(fullPath);
    }

    @Override
    public Object postRequest(String path, Object body) {
        return null;
    }

    @Override
    public Object putRequest(String path, Object body) {
        return null;
    }

    @Override
    public Object deleteRequest(String path) {
        return null;
    }

    private Object defaultResponse(String path) {
        // You can return a Map, a string message, or a specific error DTO
        return Map.of(
                "status", "SERVICE_UNAVAILABLE",
                "message", "Fallback response for path: " + path
        );
    }
}
