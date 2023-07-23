package com.ashu.prop;

import io.swagger.v3.oas.models.annotations.OpenAPI31;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPI31
public class PropertyApplication {

	//For API Docs: http://localhost:8080/swagger-ui/4.15.5/index.html
	public static void main(String[] args) {
		SpringApplication.run(PropertyApplication.class, args);

	}
}