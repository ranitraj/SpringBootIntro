package com.example.springIntro.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/studentList")
//The Annotation @RestController makes the current class 'Serve' the REST endpoints defined in this class
public class StudentController {

    // The annotation @GetMapping is the GET call for the REST API Endpoint 'hello()'
    @GetMapping
    public List<Student> getStudentList() {
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
