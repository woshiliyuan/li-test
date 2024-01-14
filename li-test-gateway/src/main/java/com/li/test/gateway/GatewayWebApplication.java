package com.li.test.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yuan.li
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayWebApplication.class, args);
	}

}
