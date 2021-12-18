package com.controller;

import com.dao.RequestDao;
import com.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {
    private RequestDao requestDao;

    @Autowired
    public RequestController(RequestDao requestDao){
        this.requestDao=requestDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model)
    {
        List<Request> requests= requestDao.getAll();
        model.addAttribute("requests",requests);
        return "request-list";
    }
    @RequestMapping("/list/pending")
    public String listPending(Model model)
    {
        List<Request> requests= requestDao.getByStatus("Pending");
        model.addAttribute("requests",requests);
        return "request-pending";
    }
    @RequestMapping("/list/approved")
    public String listApproved(Model model)
    {
        List<Request> requests= requestDao.getByStatus("Considering");
        model.addAttribute("requests",requests);
        return "request-considered";
    }

    @RequestMapping("/list/dismissed")
    public String listDismissed(Model model)
    {
        List<Request> requests= requestDao.getByStatus("Dismissed");
        model.addAttribute("requests",requests);
        return "request-dismissed";
    }

}
