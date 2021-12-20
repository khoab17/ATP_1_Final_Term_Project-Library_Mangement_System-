package com.controller;

import com.dao.CredentialDao;
import com.dao.UserDao;
import com.model.Credential;
import com.model.CredentialUser;
import com.model.User;
import com.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private UserDao userDao;
    private CredentialDao credentialDao;
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserDao userDao,CredentialDao credentialDao,UserService userService) {
        this.userDao = userDao;
        this.credentialDao=credentialDao;
        this.userService=userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userDao.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @RequestMapping("/create")
    public String create(Model model)
    {
        model.addAttribute("credentialUser",new CredentialUser());
        return "user-form";
    }

    @RequestMapping ("/update")
    public String update(@RequestParam("id") int id,Model model){
        CredentialUser credentialUser=userService.getById(id);
        model.addAttribute("credentialUser",credentialUser);
        return "user-update";
    }

    @RequestMapping ("/save")
    public String save(@Valid @ModelAttribute("credentialUser") CredentialUser credentialUser,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "user-form";
        }
        else
        {
            User user=credentialUser.getUser();
            Credential credential=credentialUser.getCredential();
            user.setEmail(credential.getEmail());
            user.setCredential(credential);
            credential.setUser(user);
            credentialDao.update(credential);
            return "redirect:/user/list";
        }

    }

    @RequestMapping ("/saveUpdate")
    public String saveUpdate(@Valid @ModelAttribute("credentialUser") CredentialUser credentialUser,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "user-update";
        }
        else
        {
            User user=credentialUser.getUser();
            Credential credential=credentialUser.getCredential();
            user.setEmail(credential.getEmail());
            user.setCredential(credential);
            credential.setUser(user);
            credentialDao.update(credential);
            return "redirect:/user/list";
        }

    }


    @RequestMapping("delete")
    public String delete(int id){
        userDao.delete(id);
        return "redirect:/user/list";
    }


}
