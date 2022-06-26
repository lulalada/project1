package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class VipMovieBox implements Serializable {
    private String operation;
    private VIPMovie vipMovie;
    private ArrayList<VIPMovie> vipMovies;


    public VipMovieBox(VIPMovie vipMovie) {
        this.vipMovie = vipMovie;
    }

    public VipMovieBox(String operation, VIPMovie vipMovie) {
        this.operation = operation;
        this.vipMovie = vipMovie;
    }

    public VipMovieBox(String operation) {
        this.operation = operation;
    }

    public VipMovieBox(ArrayList<VIPMovie> vipMovies) {
        this.vipMovies = vipMovies;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public VIPMovie getVipMovie() {
        return vipMovie;
    }

    public void setVipMovie(VIPMovie vipMovie) {
        this.vipMovie = vipMovie;
    }

    public ArrayList<VIPMovie> getVipMovies() {
        return vipMovies;
    }

    public void setVipMovies(ArrayList<VIPMovie> vipMovies) {
        this.vipMovies = vipMovies;
    }
}
