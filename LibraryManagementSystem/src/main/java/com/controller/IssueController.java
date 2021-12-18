package com.controller;

import com.dao.IssueDao;
import com.model.Issue;
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
@RequestMapping("/issue")
public class IssueController {

    private IssueDao issueDao;

    @Autowired
    public IssueController(IssueDao issueDao)
    {
        this.issueDao=issueDao;
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
        List<Issue> issues= issueDao.getAll();
        model.addAttribute("issues",issues);
        return "issue-list";
    }

    @RequestMapping("create")
    public String create(Model model)
    {
        model.addAttribute("issue",new Issue());
        return "issue-create";
    }

    @RequestMapping("save")
    public String save(@Valid @ModelAttribute("issue")Issue issue, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "issue-create";
        }
        else
        {
            issueDao.update(issue);
            return "redirect:/issue/list";
        }
    }
    @RequestMapping("update")
    public String update (@RequestParam("id")int id,Model model)
    {
        model.addAttribute("issue",issueDao.get(id));
        return "issue-update";
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(@Valid @ModelAttribute("issue")Issue issue, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "issue-update";
        }
        else
        {
            issueDao.update(issue);
            return "redirect:/issue/list";
        }
    }

}
