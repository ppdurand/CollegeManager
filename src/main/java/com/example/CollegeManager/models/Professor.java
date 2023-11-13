package com.example.CollegeManager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;
    @OneToMany(mappedBy = "professor")
    private List<Course> courseList;

    public Professor() {}

    public Professor(Long idProfessor, List<Course> courseList) {
        this.idProfessor = idProfessor;
        this.courseList = courseList;
    }

    public Professor(String firstName, String lastName, Long idProfessor,
                     List<Course> courseList) {
        super(firstName, lastName);
        this.idProfessor = idProfessor;
        this.courseList = courseList;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
