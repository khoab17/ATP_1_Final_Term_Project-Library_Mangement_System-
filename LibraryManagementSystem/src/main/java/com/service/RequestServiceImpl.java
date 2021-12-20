package com.service;

import com.dao.RequestDao;
import com.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService{
    private RequestDao requestDao;

    @Autowired
    public RequestServiceImpl(RequestDao requestDao)
    {
        this.requestDao=requestDao;
    }

    @Override
    public void changeStatus(int id, String status) {
        Request request=requestDao.get(id);
        request.setStatus(status);
        requestDao.update(request);
    }
}
