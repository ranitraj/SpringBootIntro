package com.example.springIntro.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The SERVICE Layer handling the Business Logic.
 * It obtains the Requests from the API Layer (StudentController.java)
 */
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // Verifying if an entry with the same email exists in DB
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw  new IllegalStateException("Email taken");
        }
        // Save the Student in DB
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (exists) {
            studentRepository.deleteById(id);
        } else {
            throw new IllegalStateException(
              "Student with id " + id + " does not exist!"
            );
        }
    }
}
