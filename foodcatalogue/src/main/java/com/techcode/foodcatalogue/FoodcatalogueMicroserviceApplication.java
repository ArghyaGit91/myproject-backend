package com.techcode.foodcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.techcode.foodcatalogue")
@EnableDiscoveryClient
public class FoodcatalogueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcatalogueMicroserviceApplication.class, args);
	}

}
