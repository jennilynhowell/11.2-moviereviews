package com.jennilyn.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String movietitle;
    private String reviewername;
    private String reviewerage;
    private String reviewergender;
    private String revieweroccupation;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Review() {}

    public Review(String movietitle, String reviewername, String reviewerage, String reviewergender, String revieweroccupation, int rating, Movie movie) {
        this.movietitle = movietitle;
        this.reviewername = reviewername;
        this.reviewerage = reviewerage;
        this.reviewergender = reviewergender;
        this.revieweroccupation = revieweroccupation;
        this.rating = rating;
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReviewername() {
        return reviewername;
    }

    public void setReviewername(String reviewername) {
        this.reviewername = reviewername;
    }

    public String getReviewerage() {
        return reviewerage;
    }

    public void setReviewerage(String reviewerage) {
        this.reviewerage = reviewerage;
    }

    public String getReviewergender() {
        return reviewergender;
    }

    public void setReviewergender(String reviewergender) {
        this.reviewergender = reviewergender;
    }

    public String getRevieweroccupation() {
        return revieweroccupation;
    }

    public void setRevieweroccupation(String revieweroccupation) {
        this.revieweroccupation = revieweroccupation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }
}
