package com.example.CollegeManager.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    @OneToMany(mappedBy = "student")
    @Nullable
    private List<Registration> registrationList;
    private float collegeAverage;

    public Student() {}
    public Student(Long idStudent, List<Registration> registrationList, float collegeAverage) {
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeAverage = collegeAverage;
    }

    public Student(String firstName, String lastName, Long idStudent,
                   List<Registration> registrationList, float collegeAverage) {
        super(firstName, lastName);
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeAverage = collegeAverage;
    }

    public Student(String firstName, String lastName, List<Registration> registrationList) {
        super(firstName, lastName);
        this.registrationList = registrationList;
    }
}
