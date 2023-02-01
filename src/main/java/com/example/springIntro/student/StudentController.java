package com.example.springIntro.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * API Layer
 */
@RestController
@RequestMapping(path = "api/v1/studentList")
//The Annotation @RestController makes the current class 'Serve' the REST endpoints defined in this class
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }
}
