package com.techcode.foodcatalogue.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;



public abstract class GenericFallbackFactory<T> implements FallbackFactory<T> {

    private static final Logger log = LoggerFactory.getLogger(GenericFallbackFactory.class);

    @Override
    public T create(Throwable cause) {
        log.error("Feign client fallback triggered: {}", cause.getMessage(), cause);
        return createFallback(cause);
    }

    protected abstract T createFallback(Throwable cause);
}
