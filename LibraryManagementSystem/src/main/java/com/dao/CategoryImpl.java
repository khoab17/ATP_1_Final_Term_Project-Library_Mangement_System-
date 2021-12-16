package com.dao;

import com.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryImpl implements CategoryDao{
    private SessionFactory sessionFactory;
    public CategoryImpl(){}
    public CategoryImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory =sessionFactory;
    }


    @Override
    @Transactional
    public List<Category> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query<Category> categoryQuery=session.createQuery("from Category ",Category.class);
        List<Category> categories=categoryQuery.getResultList();
        return categories==null? new ArrayList<Category>():categories;
    }

    @Override
    @Transactional
    public Category get(int id) {
        Session session=sessionFactory.getCurrentSession();
        Category category=session.get(Category.class,id);
        return  category;
    }

    @Override
    @Transactional
    public void update(Category category) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Category category=session.byId(Category.class).load(id);
        session.delete(category);
    }
}
