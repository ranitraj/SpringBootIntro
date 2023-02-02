package com.example.springIntro.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The DATA-ACCESS LAYER which interacts with the Database
 * JpaRepository<Student, Long> ->
 *     Here, Student = Object &
 *     Long = dataType of identifier (private Long id {inside the Student Entity})
 */
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    /**
     * Returns the 'Student' object if the Query finds a match for the
     * email supplied from the StudentService class. (using JPQL Query)
     * @param email - email supplied in the Request-Body from frontend
     * @return Student
     */
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
