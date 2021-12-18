package com.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "fname")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String firstName;

    @Column(name = "lname")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String lastName;

    @Column(name="gender")
    @NotNull(message = "Can not be empty")
    private String gender;

    @Column(name="dateOfBirth")
    @NotNull(message = "Can not be empty")
    private String dateOfBirth;

    @Column(name="contact")
    @NotNull(message = "Can not be empty")
    private  String contact;

    @Column(name="email")
    @NotNull(message = "Can not be empty")
    @Email(message = "Should be in email format")
    private String email;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "cId")
    private Credential credential;

    public User(){}

    public User(Integer userId, String firstName, String lastName, String gender, String dateOfBirth, String contact, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
    }

    public User(String firstName, String lastName, String gender, String dateOfBirth, String contact, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.email = email;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
