package com.usto.re.uDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class UDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UDiscoveryApplication.class, args);
	}

}
