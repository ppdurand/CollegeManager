package com.example.CollegeManager.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
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
