package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class VIPMovie implements Movie, Serializable {
    private Long id;
    private String name;
    private int year;
    private ArrayList<Genre> genre;
    private String country;
    private double rating;
    private Director director;
    private ArrayList <Actor> actors = new ArrayList<>();
    private String review;
    private int rating_count;

    public VIPMovie() {
    }

    public VIPMovie(Long id, String name, int year, ArrayList<Genre> genre, String country, double rating, Director director, ArrayList<Actor> actors, String review, int rating_count) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.country = country;
        this.rating = rating;
        this.director = director;
        this.actors = actors;
        this.review = review;
        this.rating_count = rating_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<Genre> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<Genre> genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating_count() {
        return rating_count;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }



    @Override
    public String getInfo() {
        return name + " " + year + "|" + genre + "|" + country + "|" + rating + "|" + director + "|" + actors;
    }

    @Override
    public double rateMovie(double n) {
        rating_count++;
        this.rating = (rating + n)/rating_count;
        return rating;
    }

    public String toString(){
        return id + "|" + name + "|" + year + "|" + genre + "|" + country + "|" + rating + "|" + director + "|" + actors + "|" + review + "|" + rating_count;
    }
}
