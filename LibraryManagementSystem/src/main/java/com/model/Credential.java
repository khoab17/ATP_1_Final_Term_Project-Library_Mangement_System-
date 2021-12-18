package com.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "credential")
public class Credential {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email")
    @NotNull(message="Can not be null")
    @Email(message = "Should be in email format")
    private String email;

    @Column(name="password")
    @NotNull(message = "Can not be empty")
    private String password;

    @Column(name = "role")
    @NotNull(message = "Can not be empty")
    private String role;

    @OneToOne(mappedBy = "credential",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private User user;

    public Credential(){}

    public Credential(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Credential(Integer id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
