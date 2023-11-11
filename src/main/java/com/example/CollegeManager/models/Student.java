package com.example.CollegeManager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    @OneToMany
    private List<Registration> registrationList;
    private float collegeAverage;

    public Student() {}
    public Student(Long idStudent, List<Registration> registrationList, float collegeAverage) {
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeAverage = collegeAverage;
    }

    public Student(Long idPerson, String firstName, String lastName, Long idStudent,
                   List<Registration> registrationList, float collegeAverage) {
        super(idPerson, firstName, lastName);
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeAverage = collegeAverage;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public float getCollegeMedia() {
        return collegeAverage;
    }

    public void setCollegeMedia(float collegeAverage) {
        this.collegeAverage = collegeAverage;
    }
}
