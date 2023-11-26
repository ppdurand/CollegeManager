package com.example.CollegeManager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Professor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Course> courseList;

    public Professor() {}

    public Professor(Long idProfessor, List<Course> courseList) {
        this.idProfessor = idProfessor;
        this.courseList = courseList;
    }

    public Professor(String firstName, String lastName, List<Course> courseList) {
        super(firstName, lastName);
        this.courseList = courseList;
    }
}
