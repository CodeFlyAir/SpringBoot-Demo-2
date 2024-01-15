package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String name);
    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);
}
