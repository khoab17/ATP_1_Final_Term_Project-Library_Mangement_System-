package com.controller;

import com.dao.CredentialDao;
import com.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("login")
public class LoginController {

    private CredentialDao credentialDao;

    @Autowired
    public LoginController(CredentialDao credentialDao)
    {
        this.credentialDao=credentialDao;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("")
    public String login(Model model)
    {
        model.addAttribute("login",new Login());
        return "login-form";
    }

    @RequestMapping("authenticate")
    public String authenticate(@Valid @ModelAttribute("login")Login login, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return"login-form";
        }
        else
        {
            return null;
        }
    }


}
