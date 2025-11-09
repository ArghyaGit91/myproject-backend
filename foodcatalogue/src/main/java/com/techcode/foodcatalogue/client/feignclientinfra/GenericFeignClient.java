package com.techcode.foodcatalogue.client.feignclientinfra;


import com.techcode.foodcatalogue.client.GenericFallbackFactory;
import com.techcode.foodcatalogue.client.config.GenericFeignConfig;
import feign.Body;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


public interface GenericFeignClient {

    @RequestLine("GET {fullPath}")
    Object getRequest(@Param("fullPath") String fullPath);

    @RequestLine("POST {path}")
    @Body("{body}")
    Object postRequest(@Param("path") String path, Object body);

    @RequestLine("PUT {path}")
    @Body("{body}")
    Object putRequest(@Param("path") String path, Object body);

    @RequestLine("DELETE {path}")
    Object deleteRequest(@Param("path") String path);
}
