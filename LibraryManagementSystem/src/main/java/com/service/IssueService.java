package com.service;

import com.model.Issue;

public interface IssueService {
    public void createIssue(Issue issue);
    public void changeStatus(int id,String status);
}
