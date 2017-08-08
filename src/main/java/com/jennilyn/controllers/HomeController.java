package com.jennilyn.controllers;

import com.jennilyn.interfaces.MovieRepository;
import com.jennilyn.interfaces.ReviewRepository;
import com.jennilyn.interfaces.UserRepository;
import com.jennilyn.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    MovieRepository movieRepo;

    @Autowired
    ReviewRepository reviewRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/")
    public String index(Model model){
        long featureId = 2;
        Iterable<Movie> movies = movieRepo.findAll();
        Movie feature = movieRepo.findOne(featureId);
        model.addAttribute("movies", movies);
        model.addAttribute("feature", feature);
        return "index";
    }


}
