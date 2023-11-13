package com.example.CollegeManager.dto;

import com.example.CollegeManager.models.Person;
import com.example.CollegeManager.models.Registration;
import com.example.CollegeManager.models.Student;

import java.util.List;

public class CreateStudent extends Person {
    private List<Registration> registrationList;

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public Student toStudent(){
        Student student = new Student(this.getFirstName(), this.getLastName(), this.getRegistrationList());
        return student;
    }
}
