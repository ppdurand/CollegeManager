package com.example.CollegeManager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    @OneToOne
    private List<Registration> registrationList;
    private float collegeMedia;

    public Student() {}
    public Student(Long idStudent, List<Registration> registrationList, float collegeMedia) {
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeMedia = collegeMedia;
    }

    public Student(Long idPerson, String firstName, String lastName, Long idStudent, List<Registration> registrationList, float collegeMedia) {
        super(idPerson, firstName, lastName);
        this.idStudent = idStudent;
        this.registrationList = registrationList;
        this.collegeMedia = collegeMedia;
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
        return collegeMedia;
    }

    public void setCollegeMedia(float collegeMedia) {
        this.collegeMedia = collegeMedia;
    }
}
