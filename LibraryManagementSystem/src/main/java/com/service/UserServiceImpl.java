package com.service;


import com.model.Credential;
import com.model.CredentialUser;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
    private SessionFactory sessionFactory;

    @Autowired
    public UserServiceImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory=sessionFactory;
    }

    @Override
    @Transactional
    public CredentialUser getById(int uId) {
        Session session=sessionFactory.getCurrentSession();
        User user=session.get(User.class,uId);
        int cId=user.getCredential().getId();
        Query<Credential> credentialQuery = session.createQuery("from Credential where id="+"'"+cId+"'", Credential.class);
        Credential credential=credentialQuery.getSingleResult();
        CredentialUser credentialUser=new CredentialUser();
        credentialUser.setUser(user);
        credentialUser.setCredential(credential);
        return credentialUser;
    }
}
