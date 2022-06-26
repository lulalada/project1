package lab1;

import java.util.ArrayList;

public interface Movie {
    String getInfo();
    double rateMovie(double n);
    String getName();
    int getYear();
    ArrayList<Genre> getGenre();
    String getCountry();
    ArrayList<Actor> getActors();
    double getRating();
    Director getDirector();
}
