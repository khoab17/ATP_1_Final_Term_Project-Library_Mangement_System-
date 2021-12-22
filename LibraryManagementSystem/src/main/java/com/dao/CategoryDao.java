package com.dao;

import com.model.Category;
import com.model.Credential;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAll();
    public Category get(int id);
    public void update(Category category);
    public void delete(int id);
}
