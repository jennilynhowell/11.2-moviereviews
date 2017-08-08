package com.jennilyn.controllers;

import com.jennilyn.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

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
}
