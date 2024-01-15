package com.demo.springdatajpademo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_Sequence",
            schema = "student_Sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_Sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_id",unique = true,nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
