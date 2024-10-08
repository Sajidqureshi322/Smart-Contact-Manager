package com.scm.scm.controllers;

import com.scm.scm.entites.Providers;
import com.scm.scm.entites.User;
import com.scm.scm.helpers.Message;
import com.scm.scm.helpers.MessageType;
import com.scm.scm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm.forms.UserForm;

@Controller
public class pageController {

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }
    @Autowired
    private UserService userService;
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

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }

        // save to database

        // userservice

        // UserForm--> User
//        User user = User.builder()
//                .name(userForm.getName())
//                .email(userForm.getEmail())
//                .password(userForm.getPassword())
//                .about(userForm.getAbout())
//                .phoneNumber(userForm.getPhoneNumber())
//                .provider(Providers.SELF)
//                .profilePic(
//                        "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75")
//                .build();
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://upload.wikimedia.org/wikipedia/commons/a/ac/Default_pfp.jpg?20200418092106");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        //add the message
        Message message = Message.builder().content("Registration successful").type(MessageType.blue).build();

        session.setAttribute("message",message);
        // redirect to login page
        return "redirect:/register";
    }
    
}
