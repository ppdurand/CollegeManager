package com.example.CollegeManager.dto;

import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.models.Person;
import com.example.CollegeManager.models.Professor;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CreateProfessor extends Person{
    @Getter
    @Setter
    @Nullable
    private List<Course> courseList;

    public Professor toProfessor(){
        Professor professor = new Professor(this.getFirstName(), this.getLastName(), this.getCourseList());
        return professor;
    }
}
