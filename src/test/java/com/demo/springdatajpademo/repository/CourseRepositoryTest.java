package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Course;
import com.demo.springdatajpademo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
                .title("SPM")
                .credits(3)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    void getCourseWithPagination(){
        Pageable firstPageWithThreeRecords=
                PageRequest.of(0,2);

        Pageable secondPageWithTwoRecords=
                PageRequest.of(1,2);

        List<Course> courses=repository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println(courses);
    }
}