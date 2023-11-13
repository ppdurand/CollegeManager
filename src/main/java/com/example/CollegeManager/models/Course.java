package com.example.CollegeManager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String name;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @OneToMany(mappedBy = "course")
    private List<Registration> registrationList;

    public Course() {}

    public Course(Long idCourse, String name, Professor professor, List<Registration> registrationList) {
        this.idCourse = idCourse;
        this.name = name;
        this.professor = professor;
        this.registrationList = registrationList;
    }
}
