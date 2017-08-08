package com.jennilyn.controllers;

import com.jennilyn.interfaces.MovieRepository;
import com.jennilyn.interfaces.ReviewRepository;
import com.jennilyn.interfaces.UserRepository;
import com.jennilyn.models.Movie;
import com.jennilyn.models.Review;
import com.jennilyn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ReviewController {

    @Autowired
    MovieRepository movieRepo;

    @Autowired
    ReviewRepository reviewRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/movie/{movieId}/addReview", method = RequestMethod.POST)
    public String addReview(@PathVariable("movieId") long movieId,
                            @RequestParam("rating") int rating,
                            Principal principal){

        String username = principal.getName();
        User user = userRepo.findByUsername(username);

        Movie movie = movieRepo.findOne(movieId);
        Review newReview = new Review(rating, movie);
        newReview.setUser(user);

        reviewRepo.save(newReview);
        return "redirect:/movie/" + movieId;
    }

    //TODO: add endpoint for viewing all your reviews
}
