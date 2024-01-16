package com.demo.springdatajpademo.repository;

import com.demo.springdatajpademo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByGuardianName(String name);
    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    List<Student> getStudentByEmail(String email);

    //JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.emailId = ?1")
    String getStudentFirstNameByEmail(String email);

    //Native SQL
    @Query(
            value = "SELECT * FROM student WHERE email_id = ?1",
            nativeQuery = true
    )
    List<Student> getStudentByEmailNative(String email);

    //Native Named SQL
    @Query(
            value = "SELECT * FROM student WHERE email_id = :email_id",
            nativeQuery = true
    )
    List<Student> getStudentByEmailNativeNamedQuery(@Param("email_id") String email);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE student SET first_name = ?1 WHERE email_id = ?2",
            nativeQuery = true
    )
    void updateFirstNameByEmail(String firstName,String emailId);
}
