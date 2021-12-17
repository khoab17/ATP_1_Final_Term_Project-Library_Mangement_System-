package com.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name="bookId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="title")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String title;

    @Column (name="publisher")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String publisher;

    @Column(name="author")
    @NotNull(message = "Can not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "only alphabets allowed")
    private String author;

    @Column (name="numberOfCopies")
    @NotNull(message = "Can not be empty")
    @Min(value = 1)
    private Integer numberOfCopies;

    @Column (name = "numberOfAvailableCopies")
    private Integer numberOfAvailableCopies;

    @Column(name="categoryId")
    @NotNull(message = "Can not be empty")
    private  Integer categoryId;

    public Book(){}

    public Book(Integer id, String title, String publisher, String author, Integer numberOfCopies, Integer numberOfAvailableCopies, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        this.numberOfAvailableCopies = numberOfAvailableCopies;
        this.categoryId = categoryId;
    }

    public Book(String title, String publisher, String author, Integer numberOfCopies, Integer numberOfAvailableCopies, Integer categoryId) {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        this.numberOfAvailableCopies = numberOfAvailableCopies;
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
        return numberOfAvailableCopies;
    }

    public void setNumberOfAvailableCopies(Integer numberOfAvailableCopies) {
        this.numberOfAvailableCopies = numberOfAvailableCopies;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
