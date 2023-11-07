package com.example.CollegeManager.models;

import java.util.List;

public class Student extends Person{
    private Long idStudent;
    private List<Registration> registrationList;
    private float collegeMedia;

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
