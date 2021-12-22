package com.service;

import com.model.Credential;

public interface LoginService {
    public Credential authenticate(String email,String password);
}
