package com.example.CollegeManager.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    @NotNull
    @NotBlank
    private String name;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @Nullable
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public Course() {}

    public Course(Long idCourse, String name, Professor professor) {
        this.idCourse = idCourse;
        this.name = name;
        this.professor = professor;
    }

    public Course(String name) {
        this.name = name;
    }
}
