package com.example.CollegeManager.dto;

import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.models.Person;
import com.example.CollegeManager.models.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateStudent extends Person{

    private List<Course> courses;

    public CreateStudent(){}

    public CreateStudent(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }
    public Student toStudent(){
        Student student = new Student(this.getFirstName(), this.getLastName(), this.getCourses() );
        return student;
    }
}
