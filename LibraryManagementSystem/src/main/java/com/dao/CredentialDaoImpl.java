package com.dao;

import com.model.Credential;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CredentialDaoImpl implements CredentialDao{
    private SessionFactory sessionFactory;
    public CredentialDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }


    @Override
    public List<Credential> getAll() {
        Session session=sessionFactory.getCurrentSession();
        Query<Credential> credentialQuery=session.createQuery("from Credential ",Credential.class);
        List<Credential> credentials=credentialQuery.getResultList();
        return credentials==null? new ArrayList<Credential>():credentials;
    }

    @Override
    @Transactional
    public Credential get(int id) {
        Session session=sessionFactory.getCurrentSession();
        Credential credential= session.get(Credential.class,id);
        return credential;
    }

    @Override
    @Transactional
    public void update(Credential credential) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(credential);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session=sessionFactory.getCurrentSession();
        Credential credential=session.byId(Credential.class).load(id);
        session.delete(credential);
    }
}
