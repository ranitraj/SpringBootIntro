package com.example.springIntro.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Configuration class to INSERT Student objects into the 'student' database
 * on the application launch using CommandLineRunner
 */
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository
    ) {
        return args -> {
            // Creating an entry for Student-1
            Student ranit = new Student(
                    "Ranit Raj Ganguly",
                    LocalDate.of(1996, Month.AUGUST, 29),
                    25,
                    "ranitrajganguly@gmail.com"
            );

            // Creating an entry for Student-2
            Student anvesh = new Student(
                    "Anvesh Rao Kosuru",
                    LocalDate.of(1994, Month.NOVEMBER, 30),
                    27,
                    "ark.anvesh@gmail.com"
            );

            // Saving the Data into the Database via Repository
            studentRepository.saveAll(
                    List.of(ranit, anvesh)
            );
        };
    }
}
