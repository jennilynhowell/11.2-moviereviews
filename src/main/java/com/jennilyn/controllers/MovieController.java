package com.jennilyn.controllers;

import com.jennilyn.interfaces.MovieRepository;
import com.jennilyn.interfaces.ReviewRepository;
import com.jennilyn.models.Movie;
import com.jennilyn.models.Review;
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

    @Autowired
    ReviewRepository reviewRepo;

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
        model.addAttribute("movie", movie);
        return "movieDetail";
    }

    @RequestMapping(value = "/movie/{movieId}/addReview", method = RequestMethod.POST)
    public String addReview(@PathVariable("movieId") long movieId,
                            @RequestParam("movietitle") String movietitle,
                            @RequestParam("rating") int rating,
                            @RequestParam("reviewername") String reviewername,
                            @RequestParam("age") String age,
                            @RequestParam("reviewergender") String reviewergender,
                            @RequestParam("revieweroccupation") String revieweroccupation){
        Movie movie = repo.findOne(movieId);
        Review newReview = new Review(movietitle, reviewername, age, reviewergender, revieweroccupation, rating, movie);
        reviewRepo.save(newReview);
        return "redirect:/movie/" + movieId;
    }

}
