package com.techcode.foodcatalogue.client.config;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericFeignConfig {

    public RequestInterceptor dynamicUrlInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                // Optional: Add common headers
                template.header("Content-Type", "application/json");
                // You can also add trace IDs or auth tokens if needed
            }
        };
    }

}
