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
    @OneToMany(mappedBy = "course")
    private List<Registration> registrationList;

    public Course() {}

    public Course(Long idCourse, String name, Professor professor, List<Registration> registrationList) {
        this.idCourse = idCourse;
        this.name = name;
        this.professor = professor;
        this.registrationList = registrationList;
    }

    public Course(String name, List<Registration> registrationList) {
        this.name = name;
        this.registrationList = registrationList;
    }
}
