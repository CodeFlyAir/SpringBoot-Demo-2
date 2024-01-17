package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Course;
import com.demo.springdatajpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    void saveTeacher(){
        Course course=Course.builder()
                .title("DBMS")
                .credits(3)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("James")
                .lastName("Malvin")
//                .courses(List.of(course))
                .build();

        repository.save(teacher);
    }
}