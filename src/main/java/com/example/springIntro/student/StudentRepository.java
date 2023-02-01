package com.example.springIntro.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The DATA-ACCESS LAYER which interacts with the Database
 * JpaRepository<Student, Long> ->
 *     Here, Student = Object &
 *     Long = dataType of identifier (private Long id {inside the Student Entity})
 */
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

}
