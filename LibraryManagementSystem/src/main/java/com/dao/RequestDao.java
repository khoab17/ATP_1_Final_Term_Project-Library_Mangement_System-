package com.dao;

import com.model.Request;

import java.util.List;

public interface RequestDao {
    public List<Request> getAll();
    public List<Request> getByStatus(String status);
    public Request get(int id);
    public void update(Request request);
    public void delete(int id);
}
