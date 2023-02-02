package com.example.springIntro.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    /**
     * The @Transactional keyword handles all updates to the DB.
     * We need to update the student object we obtained from the DB using the setter
     */
    @Transactional
    public void updateStudent(
            Long studentId,
            String name,
            String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentId + " does not exist!")
        );

        // Validations for name and email
        if (name != null
                && !name.isEmpty()
                && !Objects.equals(student.getName(), name)) {
            // For updating 'student' object in DB using @Transactional
            student.setName(name);
        }

        if (email != null
                && !email.isEmpty()
                && !Objects.equals(student.getEmail(), email)) {
            // Additional check to verify if new email is taken or not
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            // Update
            student.setEmail(email);
        }
    }
}
