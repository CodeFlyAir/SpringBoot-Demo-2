package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Course;
import com.demo.springdatajpademo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    void saveCourseMaterial(){
        Course course=Course.builder()
                .title("DSA")
                .credits(4)
                .build();

        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("www.google.com/course")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    void fetchCourseMaterial(){
        List<CourseMaterial> courseMaterials=repository.findAll();
        System.out.println(courseMaterials);
    }
}