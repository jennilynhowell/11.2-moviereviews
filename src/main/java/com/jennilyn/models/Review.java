package com.jennilyn.models;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewerName;
    private String reviewerAge;
    private String reviewerGender;
    private String reviewerOccupation;
    private int rating;

    //movie name and fk will come from Movie model


    public Review() {}

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerAge() {
        return reviewerAge;
    }

    public void setReviewerAge(String reviewerAge) {
        this.reviewerAge = reviewerAge;
    }

    public String getReviewerGender() {
        return reviewerGender;
    }

    public void setReviewerGender(String reviewerGender) {
        this.reviewerGender = reviewerGender;
    }

    public String getReviewerOccupation() {
        return reviewerOccupation;
    }

    public void setReviewerOccupation(String reviewerOccupation) {
        this.reviewerOccupation = reviewerOccupation;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
