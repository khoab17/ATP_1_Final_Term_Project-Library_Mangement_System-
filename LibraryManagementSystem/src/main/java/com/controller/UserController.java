package com.controller;

import com.dao.UserDao;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;

    public UserController() {
    }

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @RequestMapping("/create")
    public String create()
    {
        return "user-form";
    }
    @RequestMapping ("/update")
    public String update(@RequestParam("id") int id,Model model){
        User user=userDao.get(id);
        model.addAttribute("user",user);
        return "user-update";
    }
    @RequestMapping ("/save")
    public String save(@ModelAttribute("user") User user)
    {
        userDao.update(user);
        return "redirect:/user/list";
    }
    @RequestMapping("delete")
    public String delete(int id){
        userDao.delete(id);
        return "redirect:/user/list";
    }


}
