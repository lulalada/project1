package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieBox implements Serializable {
    private String operation;
    private RegularMovie movie;
    private ArrayList<RegularMovie> movies;
    private Long id;

    public MovieBox(String operation, RegularMovie movie) {
        this.operation = operation;
        this.movie = movie;
    }

    public MovieBox(Long id) {
        this.id = id;
    }

    public MovieBox(String operation) {
        this.operation = operation;
    }

    public MovieBox(RegularMovie movie) {
        this.movie = movie;
    }

    public MovieBox(ArrayList<RegularMovie> movies) {
        this.movies = movies;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public RegularMovie getMovie() {
        return movie;
    }

    public void setMovie(RegularMovie movie) {
        this.movie = movie;
    }

    public ArrayList<RegularMovie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<RegularMovie> movies) {
        this.movies = movies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}