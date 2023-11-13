package com.example.CollegeManager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistration;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    private float firstAvaliation;
    private float secondAvaliation;
    private float thirdAvaliation;
    private float fourthAvaliation;

    public Registration(){}

    public Registration(Long idRegistration, Student student, Course course, float firstAvaliation,
                        float secondAvaliation, float thirdAvaliation, float fourthAvaliation) {
        this.idRegistration = idRegistration;
        this.student = student;
        this.course = course;
        this.firstAvaliation = firstAvaliation;
        this.secondAvaliation = secondAvaliation;
        this.thirdAvaliation = thirdAvaliation;
        this.fourthAvaliation = fourthAvaliation;
    }
}
