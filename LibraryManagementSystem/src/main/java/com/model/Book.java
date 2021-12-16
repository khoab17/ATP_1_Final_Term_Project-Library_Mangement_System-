package com.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column (name="publisher")
    private String publisher;

    @Column(name="author")
    private String author;

    @Column (name="numberOfCopies")
    private Integer numberOfCopies;

    @Column (name = "numberOfAvailableCopies")
    private Integer NumberOfAvailableCopies;

    @Column(name="categoryId")
    private  Integer categoryId;

    public Book(){}

    public Book(Integer id, String title, String publisher, String author, Integer numberOfCopies, Integer numberOfAvailableCopies, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        NumberOfAvailableCopies = numberOfAvailableCopies;
        this.categoryId = categoryId;
    }

    public Book(String title, String publisher, String author, Integer numberOfCopies, Integer numberOfAvailableCopies, Integer categoryId) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        NumberOfAvailableCopies = numberOfAvailableCopies;
        this.categoryId = categoryId;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(Integer numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public Integer getNumberOfAvailableCopies() {
        return NumberOfAvailableCopies;
    }

    public void setNumberOfAvailableCopies(Integer numberOfAvailableCopies) {
        NumberOfAvailableCopies = numberOfAvailableCopies;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
