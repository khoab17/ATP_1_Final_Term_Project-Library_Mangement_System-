package com.controller;


import com.dao.BookDao;
import com.model.Book;
import com.service.CategoryService;
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
@RequestMapping("/book")
public class BookController {

    private BookDao bookDao;
    private CategoryService categoryService;

    @Autowired
    public BookController(BookDao bookDao ,CategoryService categoryService)
    {
        this.bookDao=bookDao;
        this.categoryService=categoryService;
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
        List<Book> books=bookDao.getAll();
        model.addAttribute("books",books);
        return "book-list";
    }
    @RequestMapping("create")
    public String create(Model model)
    {
        //model.addAttribute("categories",bookCategoryService.getCategories());
        model.addAttribute("book",new Book());
        model.addAttribute("categories",categoryService.getAll());
        return "book-create";
    }

    @RequestMapping("save")
    public String save(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("categories",categoryService.getAll());
            return "book-create";
        }
        else {
            book.setNumberOfAvailableCopies(book.getNumberOfCopies());
            bookDao.update(book);
            return "redirect:/book/list";
        }
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {

            return "book-update";
        }
        else {
            book.setNumberOfAvailableCopies(book.getNumberOfCopies());
            bookDao.update(book);
            return "redirect:/book/list";
        }
    }

    @RequestMapping("update")
    public String update(@RequestParam("id") int id, Model model)
    {
        Book book=bookDao.get(id);
        model.addAttribute("book",book);
        model.addAttribute("categories",categoryService.getAll());
        return "book-update";
    }




}
