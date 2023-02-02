package com.example.springIntro.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
