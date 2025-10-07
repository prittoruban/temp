package com.examly.springapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Person {

    @Id
    private int id;
    private String name;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "passport_id")
    @JsonManagedReference
    private Passport passport;

    public Person() {}

    public Person(int id, String name, String dateOfBirth, String email, String phoneNumber, Passport passport) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
}
