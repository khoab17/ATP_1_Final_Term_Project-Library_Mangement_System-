package com.controller;

import com.dao.CredentialDao;
import com.dao.UserDao;
import com.model.Credential;
import com.model.CredentialUser;
import com.model.User;
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

    public UserController() {
    }

    @Autowired
    public UserController(UserDao userDao,CredentialDao credentialDao) {
        this.userDao = userDao;
        this.credentialDao=credentialDao;
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
        /*Map<String,Object> map=new LinkedHashMap<>();
        map.put("user",new User());
        map.put("credential",new Credential());*/
        //model.addAttribute("user",new User());
        model.addAttribute("credentialUser",new CredentialUser());
        return "user-form-val";
    }

    @RequestMapping ("/update")
    public String update(@RequestParam("id") int id,Model model){
        User user=userDao.get(id);
        model.addAttribute("user",user);
        return null;
    }

    @RequestMapping ("/save")
    public String save(@Valid @ModelAttribute("credentialUser") CredentialUser credentialUser,BindingResult bindingResult)
    {

            //user.setCredential(credentialUser.getUser());
            //user=credentialUser.getUser();
            //credential=credentialUser.getCredential();
            /*
            Credential credential=user.getCredential();
            credential.setUser(user);
            user.setCredential(credential);
            */

            /*user.setCredential(credential);
            credential.setUser(user);
            credentialDao.update(credential);*/

            if(bindingResult.hasErrors())
            {
                return "user-form-val";
            }
            else
            {
                return "redirect:/user/list";
            }

    }


    @RequestMapping("delete")
    public String delete(int id){
        userDao.delete(id);
        return "redirect:/user/list";
    }


}
