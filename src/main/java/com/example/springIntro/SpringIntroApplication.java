package com.example.springIntro;

import com.example.springIntro.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
//The Annotation @RestController makes the current class 'Serve' the REST endpoints defined in this class
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	// The annotation @GetMapping is the GET call for the REST API Endpoint 'hello()'
	@GetMapping
	public List<Student> getStudentsList() {
		return List.of(
				new Student(
						1L,
						"Ranit",
						LocalDate.of(1996, Month.AUGUST, 5),
						25,
						"ranitrajganguly@gmail.com"
				)
		);
	}

}
