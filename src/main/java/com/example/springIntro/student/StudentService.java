package com.example.springIntro.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * The SERVICE Layer handling the Business Logic.
 * It obtains the Requests from the API Layer (StudentController.java)
 */
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
