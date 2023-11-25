package com.example.CollegeManager.dto;

import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.models.Person;
import com.example.CollegeManager.models.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateStudent{
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    private List<Course> courses;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student toStudent(){
        Student student = new Student(this.getFirstName(), this.getLastName(), this.getCourses() );
        return student;
    }
}
