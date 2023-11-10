package com.example.CollegeManager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String name;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @OneToMany
    private List<Registration> registrationList;

    public Course() {}

    public Course(Long idCourse, String name, Professor professor, List<Registration> registrationList) {
        this.idCourse = idCourse;
        this.name = name;
        this.professor = professor;
        this.registrationList = registrationList;
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }
}
