package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Course;
import com.demo.springdatajpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    void fetchCourses(){
        List<Course> courses = repository.findAll();
        System.out.println(courses);
    }

    @Test
    void saveCourseWithTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Prince")
                .lastName("Jacky")
                .build();

        Course course=Course.builder()
                .title("AFL")
                .credits(3)
                .teacher(teacher)
                .build();

        repository.save(course);
    }
}