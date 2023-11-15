package com.example.CollegeManager.dto;

import com.example.CollegeManager.models.Course;
import com.example.CollegeManager.models.Professor;
import com.example.CollegeManager.models.Registration;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCourse {
    @NotNull
    @NotBlank
    private String name;
    private Professor professor;
    @Nullable
    private List<Registration> registrationList;

    public Course toCourse(){
        Course course = new Course(this.getName(), this.getRegistrationList());
        return course;
    }
}
