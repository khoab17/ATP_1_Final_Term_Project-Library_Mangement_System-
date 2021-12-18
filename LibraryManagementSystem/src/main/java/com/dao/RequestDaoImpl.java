package com.dao;

import com.model.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao{
    private SessionFactory sessionFactory;

    @Autowired
    public RequestDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public List<Request> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query<Request> requestQuery=session.createQuery("from Request ",Request.class);
        List<Request> requests=requestQuery.getResultList();
        return requests==null? new ArrayList<Request>() : requests;
    }

    @Override
    @Transactional
    public Request get(int id) {
        Session session=sessionFactory.getCurrentSession();
        Request request=session.get(Request.class,id);
        return request;
    }

    @Override
    @Transactional
    public void update(Request request) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(request);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Request request=session.byId(Request.class).load(id);
        session.delete(request);
    }

    @Override
    @Transactional
    public List<Request> getByStatus(String status)
    {
        Session session=sessionFactory.getCurrentSession();
        Query<Request> requestQuery=session.createQuery("from Request where status="+"'"+status+"'" ,Request.class);
        List<Request> requests=requestQuery.getResultList();
        return requests==null? new ArrayList<Request>() : requests;
    }

}
