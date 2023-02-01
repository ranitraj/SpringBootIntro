package com.example.springIntro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

}
