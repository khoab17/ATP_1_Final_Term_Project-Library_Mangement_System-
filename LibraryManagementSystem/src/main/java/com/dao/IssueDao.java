package com.dao;

import com.model.Issue;

import java.util.List;

public interface IssueDao {
    public List<Issue> getAll();
    public List<Issue> getAll(String status);
    public Issue get(int id);
    public void update(Issue issue);
    public void delete(int id);
}
