package com.dao;

import com.model.Credential;

import java.util.List;

public interface CredentialDao {
    public List<Credential> getAll();
    public Credential get(int id);
    public void update(Credential credential);
    public void delete(int id);
}
