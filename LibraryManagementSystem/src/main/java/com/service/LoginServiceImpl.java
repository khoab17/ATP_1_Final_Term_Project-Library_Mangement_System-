package com.service;

import com.dao.CredentialDao;
import com.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
    private CredentialDao credentialDao;

    @Autowired
    public LoginServiceImpl(CredentialDao credentialDao)
    {
        this.credentialDao=credentialDao;
    }
    @Override
    public Credential authenticate(String email, String password) {
        Credential credential= credentialDao.authenticate(email,password);
        return credential==null? null:credential;
    }
}
