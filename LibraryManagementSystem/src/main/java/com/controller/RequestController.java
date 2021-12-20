package com.controller;

import com.dao.BookDao;
import com.dao.RequestDao;
import com.model.Book;
import com.model.Request;
import com.service.CategoryService;
import com.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {
    private RequestDao requestDao;
    private RequestService requestService;
    private BookDao bookDao;
    private CategoryService categoryService;

    @Autowired
    public RequestController(RequestDao requestDao,RequestService requestService,CategoryService categoryService,BookDao bookDao)
    {
        this.requestDao=requestDao;
        this.requestService=requestService;
        this.categoryService=categoryService;
        this.bookDao=bookDao;
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

    @RequestMapping("update")
    public String update(@RequestParam("id") int id,Model model)
    {
        model.addAttribute("request",requestDao.get(id));
        return "request-update";
    }

    @RequestMapping("update/save")
    public String updateSave(@Valid @ModelAttribute("request") Request request, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "request-update";
        }
        else
        {
            requestDao.update(request);
            return "redirect:/request/list";
        }
    }


    @RequestMapping("/list/pending")
    public String listPending(Model model)
    {
        List<Request> requests= requestDao.getByStatus("Pending");
        model.addAttribute("requests",requests);
        return "request-pending";
    }

    @RequestMapping("/pending/approve")
    public String PendingApprove(@RequestParam("id")int id)
    {
        requestService.changeStatus(id,"Considering");
        return "redirect:/request/list/pending";
    }
    @RequestMapping("pending/decline")
    public String PendingDecline(@RequestParam("id")int id)
    {
        requestService.changeStatus(id,"Declined");
        return "redirect:/request/list/pending";
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
        List<Request> requests= requestDao.getByStatus("Declined");
        model.addAttribute("requests",requests);
        return "request-dismissed";
    }

    @RequestMapping("/reconsider")
    public String reconsider(@RequestParam("id")int id)
    {
        Request request= requestDao.get(id);
        request.setStatus("Considering");
        requestDao.update(request);
        return "redirect:/request/list/dismissed";
    }

    @RequestMapping("/book/add")
    public String bookAdd(@RequestParam("id") int id,Model model)
    {
        Request request=requestDao.get(id);
        Book book=new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.getAll());
        model.addAttribute("rId",id);
        return "request-bookAdd";
    }

    @RequestMapping("book/add/save")
    public String bookAddSave(@Valid @ModelAttribute("book")Book book,BindingResult bindingResult,Model model,@ModelAttribute("rId")int rId)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("categories",categoryService.getAll());
            return "request-bookAdd";
        }
        else
        {
            book.setNumberOfAvailableCopies(book.getNumberOfCopies());
            bookDao.update(book);
            Request request=requestDao.get(rId);
            request.setStatus("Book Available");
            requestDao.update(request);
            return "redirect:/request/list";
        }
    }


}
