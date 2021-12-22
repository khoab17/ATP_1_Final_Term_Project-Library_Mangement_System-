package com.controller;

import com.dao.CredentialDao;
import com.model.Credential;
import com.model.Login;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private CredentialDao credentialDao;
    private LoginService loginService;

    @Autowired
    public LoginController(CredentialDao credentialDao,LoginService loginService)
    {
        this.credentialDao=credentialDao;
        this.loginService=loginService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @RequestMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("login",new Login());
        return "login-form";
    }

    @RequestMapping("/authenticate")
    public String authenticate(@Valid @ModelAttribute("login")Login login, BindingResult bindingResult, Model model, HttpSession session)
    {
        if(bindingResult.hasErrors())
        {
            session.setAttribute("loginFirst",null);
            model.addAttribute("errormessage",null);
            return"login-form";
        }
        else
        {
           Credential credential= loginService.authenticate(login.getEmail(),login.getPassword());
           if(credential!=null)
           {
                session.setAttribute("userEmail",credential.getEmail());
                session.setAttribute("userRole",credential.getRole());
                session.setAttribute("loginFirst",null);
                return "redirect:/user/list";
           }
           else
           {
               session.setAttribute("loginFirst",null);
               model.addAttribute("errormessage","Invalid Email or Password");
               return "login-form";
           }

        }
    }

    @RequestMapping("logout")
    public String logOut(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }

}
