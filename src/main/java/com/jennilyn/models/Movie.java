package com.jennilyn.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String genre;
    private String imdburl;
    private String releasedate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<Review> reviews;

    public Movie() {}

    public Movie(String title, String genre, String imdbUrl, String releaseDate) {
        this.title = title;
        this.genre = genre;
        this.imdburl = imdbUrl;
        this.releasedate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdburl() {
        return imdburl;
    }

    public void setImdburl(String imdburl) {
        this.imdburl = imdburl;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
