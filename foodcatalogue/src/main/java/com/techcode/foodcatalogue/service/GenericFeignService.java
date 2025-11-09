package com.techcode.foodcatalogue.service;


import com.netflix.discovery.DiscoveryClient;
import com.techcode.foodcatalogue.client.fallback.GenericFeignFallback;
import com.techcode.foodcatalogue.client.feignclientinfra.GenericFeignClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GenericFeignService {



    @Autowired
    private GenericFeignFallback fallback;

    public Object getFromService(String baseUrl, String path, Map<String,Object> queryParams) {
        StringBuilder fullPath = new StringBuilder(path);
        if (!queryParams.isEmpty()) {
            fullPath.append("?");
            queryParams.forEach((k,v) -> fullPath.append(k).append("=").append(v).append("&"));
            fullPath.deleteCharAt(fullPath.length() - 1);
        }

        GenericFeignClient client = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(GenericFeignClient.class, baseUrl);

        try {
            return client.getRequest(fullPath.toString());
        } catch (Exception e) {
            return fallback.getRequest(fullPath.toString());
        }

    }

    public Object postToService(String serviceBaseUrl, String path, Object body) {
        GenericFeignClient client = Feign.builder()
                .target(GenericFeignClient.class, serviceBaseUrl);
        return client.postRequest(path, body);
    }



}
