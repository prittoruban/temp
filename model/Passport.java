package com.examly.springapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNumber;
    private int issueYear;
    private String country;

    @OneToOne(mappedBy = "passport")
    @JsonBackReference
    private Person person;

    public Passport() {}

    public Passport(int id, String serialNumber, int issueYear, String country) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.issueYear = issueYear;
        this.country = country;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public int getIssueYear() { return issueYear; }
    public void setIssueYear(int issueYear) { this.issueYear = issueYear; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
