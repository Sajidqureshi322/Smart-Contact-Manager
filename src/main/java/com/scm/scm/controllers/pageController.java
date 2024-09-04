package com.scm.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        // sending data to view
        model.addAttribute("name", "Substring Technologies");
        model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        return "home";
    }

    // about route

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }

    // services

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("services page loading");
        return "services";
    }

    //contact page
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    //login page
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //Singup page
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
}
