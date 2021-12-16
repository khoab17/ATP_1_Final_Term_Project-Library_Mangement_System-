package com.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    @Column(name="gender")
    private String gender;

    @Column(name="dateOfBirth")
    private String DateOfBirth;

    @Column(name="contact")
    private  String contact;

    @Column(name="email")
    private String email;

    public User(){}

    public User(Integer id, String firstName, String lastName, String gender, String dateOfBirth, String contact, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        DateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
    }

    public User(String firstName, String lastName, String gender, String dateOfBirth, String contact, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        DateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
