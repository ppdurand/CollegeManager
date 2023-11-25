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
    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @Nullable
    private List<Course> courses;
    @Nullable
    private float collegeAverage;

    public Student() {}
    public Student(Long idStudent, float collegeAverage) {
        this.idStudent = idStudent;
        this.collegeAverage = collegeAverage;
    }

    public Student(String firstName, String lastName, Long idStudent, float collegeAverage) {
        super(firstName, lastName);
        this.idStudent = idStudent;
        this.collegeAverage = collegeAverage;
    }

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }
}
