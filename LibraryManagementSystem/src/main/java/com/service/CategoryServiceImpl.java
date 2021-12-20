package com.service;

import com.dao.CategoryDao;
import com.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private SessionFactory sessionFactory;

    @Autowired
    public CategoryServiceImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public LinkedHashMap<Integer, String> getAll() {

        Session session=sessionFactory.getCurrentSession();
        Query<Category> categoryQuery=session.createQuery("from Category ",Category.class);
        List<Category> categories=categoryQuery.getResultList();

        LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
        for (Category category: categories)
        {
            hashMap.put(category.getId(),category.getName());
        }
        return hashMap;
    }
}
