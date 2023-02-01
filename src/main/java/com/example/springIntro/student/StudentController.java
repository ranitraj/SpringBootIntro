package com.example.springIntro.student;


import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Autowired annotation is used for Dependency-Injection.
     * NOTE: In order to use Dependency-Injection on the 'StudentService' class,
     *      we have to specify that it has to be instantiated (ie Spring-Bean)
     *      For this, we add the Component annotation (@Service or @Component)
     *      to the 'StudentService' class.
     */
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }
}
