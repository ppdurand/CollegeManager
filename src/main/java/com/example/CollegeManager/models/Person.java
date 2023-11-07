package com.example.CollegeManager.models;

public class Person {
    private Long idPerson;
    private String firstName;
    private String lastName;

    public Person() {}

    public Person(Long idPerson, String firstName, String lastName) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

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
}
