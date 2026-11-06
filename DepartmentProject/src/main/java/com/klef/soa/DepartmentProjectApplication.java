package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DepartmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentProjectApplication.class, args);
		System.out.println("Department Project is running");
		}
	
	

}
