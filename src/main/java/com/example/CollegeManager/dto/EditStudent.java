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
public class EditStudent extends Person {
    @NotNull
    @NotBlank
    private List<Course> courses;

    public EditStudent(){}

    public EditStudent(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }

    public void fromStudent(Student student){
        this.setFirstName(student.getFirstName());
        this.setLastName(student.getLastName());
        this.setCourses(student.getCourses());
    }

    public Student toStudent(Student student){
        student.setFirstName(this.getFirstName());
        student.setLastName(this.getLastName());
        student.setCourses(this.getCourses());

        return student;
    }
}
