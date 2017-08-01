package com.jennilyn.controllers;

import com.jennilyn.interfaces.MovieRepository;
import com.jennilyn.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    @Autowired
    MovieRepository repo;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Movie> movies = repo.findAll();
        model.addAttribute("movies", movies);
        return "index";
    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public String addMovie(@RequestParam("title") String title,
                           @RequestParam("genre") String genre,
                           @RequestParam("imdburl") String imdburl,
                           @RequestParam("releasedate") String releasedate){
        Movie movie = new Movie(title, genre, imdburl, releasedate);
        repo.save(movie);
        return "redirect:/";
    }

    @RequestMapping("/movie/{movieId}")
    public String movieDetail(@PathVariable("movieId") long movieId, Model model){
        Movie movie = repo.findOne(movieId);
        return "movieDetail";
    }

}
