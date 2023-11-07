package com.example.CollegeManager.models;

public class Registration {
    private Long idRegistration;
    private Student student;
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

    public Long getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Long idRegistration) {
        this.idRegistration = idRegistration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public float getFirstAvaliation() {
        return firstAvaliation;
    }

    public void setFirstAvaliation(float firstAvaliation) {
        this.firstAvaliation = firstAvaliation;
    }

    public float getSecondAvaliation() {
        return secondAvaliation;
    }

    public void setSecondAvaliation(float secondAvaliation) {
        this.secondAvaliation = secondAvaliation;
    }

    public float getThirdAvaliation() {
        return thirdAvaliation;
    }

    public void setThirdAvaliation(float thirdAvaliation) {
        this.thirdAvaliation = thirdAvaliation;
    }

    public float getFourthAvaliation() {
        return fourthAvaliation;
    }

    public void setFourthAvaliation(float fourthAvaliation) {
        this.fourthAvaliation = fourthAvaliation;
    }
}
