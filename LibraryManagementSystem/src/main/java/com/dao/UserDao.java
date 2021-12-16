package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAll();

    public User get(int id);

    public void save(User user);

    public void update(User user);

    public void delete(int id);
}
