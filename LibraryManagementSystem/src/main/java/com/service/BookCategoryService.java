package com.service;

import com.dao.CategoryDao;
import com.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;

public class BookCategoryService {

    private CategoryDao categoryDao;


    BookCategoryService(CategoryDao categoryDao)
    {
        this.categoryDao=categoryDao;
    }

    public LinkedHashMap<Integer,String> getCategories()
    {
        LinkedHashMap<Integer,String> data=new LinkedHashMap<>();
        List<Category> categories=categoryDao.getAll();
        for(Category category:categories)
        {
            data.put(category.getId(),category.getName());
        }
        return data;
    }
}
