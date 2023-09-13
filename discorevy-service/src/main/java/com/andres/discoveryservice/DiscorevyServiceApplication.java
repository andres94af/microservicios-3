package com.andres.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscorevyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscorevyServiceApplication.class, args);
	}

}
