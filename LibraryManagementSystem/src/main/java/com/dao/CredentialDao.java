package com.dao;

import com.model.Credential;

import java.util.List;

public interface CredentialDao {
    public List<Credential> getAll();
    public Credential get(int id);
    public Credential authenticate(String email,String password);
    public void update(Credential credential);
    public void delete(int id);
}
