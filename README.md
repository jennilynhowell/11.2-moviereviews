# 11.2-moviereviews
TIY Week 11, Day 2: Movie Review website using JPA and relational database

### PART ONE
#### Objectives  
Manage multiple repository/model relations (Spring JPA)
Manage multiple controller methods and templates
Make a killer user experience
Requirements  
A user can add a movie to the database
A user can view all movies in the database
A user can view all reviews in the database
A user can create a review in the database
A user can edit a movie detail
A user CANNOT edit a review detail
You must use a CSS framework of your choice. Bootstrap, Semantic, Materialize, Foundation...
#### Normal Mode  
BEFORE YOU START!!!! READ THIS In this assignment your model structure should contain the following:

Movie Model

id
Title
Genre
IMDB Link
Release Date
Review Model

id
Name of the reviewer (string, not FK)
Movie being reviewed (FK)
Rating
Optional Age of Reviewer
Optional Gender of the Reviewer
Optional Occupation of the Reviewer
You will be required to create an endpoint for all functionality of the movie review database. This includes:

A page to view all movies in the database
A page to add a movie to the database
A page to modify a movie detail
A page to create a review for a movie (how do you pass the movie to the create review page?)
Think about URL structure and things you can include in the URL
A page to view all of the reviews for a given movie
All pages should be linked together through use of a consistent navigation bar. All pages must have consistent styling / color scheme. You are allowed to start with a color "theme" but you are required to build the HTML yourself. You are not allowed to download a free/paid template from any source.

#### Hard Mode  
All of the requirements of normal mode but include a way to show each movie's average rating. You may have to look into Transient properties on your models.


### PART TWO
In this application you will be starting from your Movie Reviewer application you created earlier this cohort.

#### Branch  
Before you get started, you will need to checkout a new branch of your Movie Reviewer project and call it spring_security. If it's not called spring_security I will send it back over as unsatisfactory.

#### Instructions  
All functional requirements for Part 1 must be met prior to beginning this project. Requirements

In a prior iteration of this project you were asked to be able to create a Review model that contained information about the reviewer. You are going to be expected to remove those values from your object definition (and database table) and replace them with a foreign key to the user who created the review.

A user should be able to review and not specify the information about themselves and the controller to create a review should automatically grab the logged in user and apply it as a foreign key to the User model.

#### Requirements  
Restrict all endpoints to be limited to logged in users only. Treat this data as sacred that users must have to sign up for. Once a user is logged in they should be able to see all endpoints.

A user should be able to login with credentials and logout by clicking a logout button.


### PART THREE
In this application you will be starting from your Movie Reviewer Part 2 application you created yesterday.

Branch  
Stay on the current spring_security branch for this assignment

#### Instructions  
All functional requirements for Part 2 must be met prior to beginning this project. Requirements

Now that the project has every endpoint "locked down" with the user authentication wall, you need to ease the restrictions a bit. Your users want to be able to view reviews and movie data without being authenticated, so in order to satisfy their requirement you need to permit all requests to the movie data and review endpoints.

However, any controller that would require a user to create data should redirect them to a login page if they are unauthenticated. For example, if i'm looking at a movie detail and it says "Hey, want to create a review? Click here!" and I click on that link, it should take me to a login page if i'm not logged in, but allow me to goto the page if I am logged in.

This will be the required functionality for the following endpoints:

Create a new movie
Create a new review
