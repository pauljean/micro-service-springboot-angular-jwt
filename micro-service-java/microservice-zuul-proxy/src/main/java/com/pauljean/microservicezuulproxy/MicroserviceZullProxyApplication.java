package com.pauljean.microservicezuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceZullProxyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceZullProxyApplication.class, args);

		
		    
	}

}


