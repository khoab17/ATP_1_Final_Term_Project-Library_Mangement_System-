package com.model;

import javax.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @Column(name = "issueId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;

    @Column(name = "dateOfIssue")
    private String dateOfIssue;

    @Column(name="dateOfReturn")
    private String dateOfReturn;

    @Column(name = "bookId")
    private Integer bookId;

    @Column (name = "studentId")
    private Integer studentId;

    @Column (name="status")
    private String status;

    @Column (name="fine")
    private Double fine;

    @Column(name = "comment")
    private String comment;

    public Issue(){}

    public Issue(Integer issueId, String dateOfIssue, String dateOfReturn, Integer bookId, Integer studentId, String status, Double fine, String comment) {
        this.issueId = issueId;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.fine = fine;
        this.comment = comment;
    }

    public Issue(String dateOfIssue, String dateOfReturn, Integer bookId, Integer studentId, String status, Double fine, String comment) {
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
        this.bookId = bookId;
        this.studentId = studentId;
        this.status = status;
        this.fine = fine;
        this.comment = comment;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
