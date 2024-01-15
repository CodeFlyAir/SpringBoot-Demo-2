package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Guardian;
import com.demo.springdatajpademo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent(){
        Guardian guardian=Guardian.builder()
                .name("Michael")
                .email("michael@gmail.com")
                .mobile("134324513")
                .build();

        Student student = Student.builder()
                .emailId("ifan@gmail.com")
                .firstName("Ifan")
                .lastName("Koaded")
                .guardian(guardian)
                .build();

        repository.save(student);
    }

    @Test
    public void fetchStudent(){
        List<Student> students = repository.findAll();
        System.out.println(students);
    }

    @Test
    public void fetchStudentByFirstName(){
        List<Student> students = repository.findByFirstName("John");
        System.out.println(students);
    }
}