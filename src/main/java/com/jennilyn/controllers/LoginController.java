package com.jennilyn.controllers;

import com.jennilyn.interfaces.UserRepository;
import com.jennilyn.models.Role;
import com.jennilyn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
        model.addAttribute("user", new User());

        //get the error message from the security
        try {
            Object message = request.getSession().getAttribute("error");
            model.addAttribute("error", message);
            //remove message after redirect
            request.getSession().removeAttribute("error");
        } catch(Exception ex) {}

        return "login";
    }

    @RequestMapping("/login/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());

        return "signup";
    }


    @RequestMapping(value = "/login/signup", method = RequestMethod.POST)
    public String signup(@RequestParam("username") String username,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("password") String password,
                         @RequestParam("age") String age,
                         @RequestParam("gender") String gender,
                         @RequestParam("occupation")String occupation,
                         HttpServletRequest request,
                         Model model){
        User user = new User(username, password, firstName, age, gender, occupation);

        userRepo.save(user);

        try {
            Object message = request.getSession().getAttribute("error");
            model.addAttribute("error", message);
            //remove message after redirect
            request.getSession().removeAttribute("error");
        } catch(Exception ex) {}

        return "redirect:/";
    }
}
