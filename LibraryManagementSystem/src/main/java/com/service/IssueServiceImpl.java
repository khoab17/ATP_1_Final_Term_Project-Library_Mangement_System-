package com.service;

import com.dao.BookDao;
import com.dao.IssueDao;
import com.model.Book;
import com.model.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueService{
    private IssueDao issueDao;
    private BookDao bookDao;

    @Autowired
    public IssueServiceImpl(IssueDao issueDao,BookDao bookDao)
    {
        this.bookDao=bookDao;
        this.issueDao=issueDao;
    }

    @Override
    public void createIssue(Issue issue) {
            Book book=bookDao.get(issue.getBookId());
            book.setNumberOfAvailableCopies(book.getNumberOfAvailableCopies()-1);
            bookDao.update(book);
            issueDao.update(issue);
    }

    @Override
    public void changeStatus(int id, String status) {
        if(status.equals("approved"))
        {
            Issue issue = issueDao.get(id);
            issue.setStatus(status);
            Book book=bookDao.get(issue.getBookId());
            book.setNumberOfAvailableCopies(book.getNumberOfAvailableCopies()+1);
            bookDao.update(book);
            issueDao.update(issue);
        }
    }

}
