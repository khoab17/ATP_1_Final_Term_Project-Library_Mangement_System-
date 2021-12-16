package com.dao;

import com.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getAll();
    public Book get(int id);
     public void update(Book book);
     public void delete(int id);
}
