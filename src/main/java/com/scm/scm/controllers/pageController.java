package com.scm.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm.forms.UserForm;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        //default data bhi dal sakte hai
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register

    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("processing registration");
        //fetch form data 
        System.out.println(userForm);

        //validate form data

        //save to database
        userService 
        //message = "Registration successful"
        //redirect to login page
        return "redirect:/register";  
    }
    
}
