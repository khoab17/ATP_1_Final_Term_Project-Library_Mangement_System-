package com.dao;

import com.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    public BookDaoImpl(){}
    public BookDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query<Book> bookQuery=session.createQuery("from Book",Book.class);
        List<Book> books=bookQuery.getResultList();
        return books==null? new ArrayList<Book>():books;
    }

    @Override
    @Transactional
    public Book get(int id) {
        Session session=sessionFactory.getCurrentSession();
        Book book=session.get(Book.class,id);
        return book;
    }

    @Override
    @Transactional
    public void update(Book book) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Book book=session.byId(Book.class).load(id);
        session.delete(book);
    }
}
