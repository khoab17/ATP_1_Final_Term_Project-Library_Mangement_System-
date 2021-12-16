package com.model;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "edition")
    private String edition;

    @Column(name = "status")
    private String status;

    @Column(name = "studentId")
    private Integer studentId;

    public Request(){}

    public Request(Integer id, String title, String author, String edition, String status, Integer studentId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.status = status;
        this.studentId = studentId;
    }

    public Request(String title, String author, String edition, String status, Integer studentId) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.status = status;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
