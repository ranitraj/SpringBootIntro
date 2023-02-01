package com.example.springIntro.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * The SERVICE Layer handling the Business Logic.
 * It obtains the Requests from the API Layer (StudentController.java)
 */
@Service
public class StudentService {
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
