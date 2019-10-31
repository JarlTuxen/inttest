package com.example.inttest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<User> users = new ArrayList<>(); // dette objekt består "forevigt"
    @RequestMapping({"", "/", "index"})
    public String index(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = {"login"}, method = RequestMethod.POST)
    public String handleSubmit(@ModelAttribute User user, Model model){
        users.add(user);
        model.addAttribute("currentuser", user.getUsername());
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping({"bootstrap"})
    public String bootstrap(Model model){
        model.addAttribute("user", new User("dit", "navn"));
        return "bootstrap";
    }

    @RequestMapping({"bootstrap2"})
    public String bootstrap2(Model model){
        model.addAttribute("user", new User("dit", "navn"));
        return "bootstrap2";
    }

}
