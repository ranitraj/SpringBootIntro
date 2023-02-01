package com.example.springIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
//The Annotation @RestController makes the current class 'Serve' the REST endpoints defined in this class
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	// The annotation @GetMapping is the GET call for the REST API Endpoint 'hello()'
	@GetMapping
	public String hello() {
		return "Hello World";
	}

}
