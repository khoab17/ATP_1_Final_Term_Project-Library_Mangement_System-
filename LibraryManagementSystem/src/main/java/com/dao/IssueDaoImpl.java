package com.dao;

import com.model.Issue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueDaoImpl implements IssueDao{
    private SessionFactory sessionFactory;
    public IssueDaoImpl(){}
    public IssueDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public List<Issue> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query<Issue> issueQuery=session.createQuery("from Issue ",Issue.class);
        List<Issue> issues=issueQuery.getResultList();
        return issues == null ? new ArrayList<Issue>():issues;
    }

    @Override
    @Transactional
    public Issue get(int id) {
        Session session=sessionFactory.getCurrentSession();
        Issue issue=session.get(Issue.class,id);
        return issue;
    }

    @Override
    @Transactional
    public void update(Issue issue) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(issue);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Issue issue=session.byId(Issue.class).load(id);
        session.delete(issue);
    }
}
