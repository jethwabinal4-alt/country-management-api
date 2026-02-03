package com.binal.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.binal.country.feignclient")
public class CountryManagementApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(CountryManagementApiApplication.class, args);
	}

}
