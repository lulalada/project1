package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        RegularMovie movie = null;
        VIPMovie vipMovie = null;
        Viewer viewer = null;
        VIPviewer vipViewer = null;
        ArrayList <Viewer> viewers = new ArrayList<>();
        ArrayList<VIPviewer> vipViewers = new ArrayList<>();
        ArrayList <RegularMovie> movies = new ArrayList<>();
        ArrayList <VIPMovie> vipMovies = new ArrayList<>();
        ArrayList <Movie> allMovie = new ArrayList<>();
        Admin admin1 = new Admin("alua@gmail.com", "alua");
        Admin admin2 = new Admin("dina@gmail.com", "dina");
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(admin1);
        admins.add(admin2);
        try{
            while (true){
                System.out.println("PRESS [1] ENTER AN ACCOUNT");
                System.out.println("PRESS [2] TO REGISTER");
                System.out.println("PRESS [3] TO VIEW MOVIES");
                System.out.println("PRESS [4] TO SEARCH FOR A MOVIE");
                System.out.println("PRESS [5] TO FILTER MOVIES");
                System.out.println("PRESS [6] TO EXIT");
                int choice = sc.nextInt();
                if(choice == 1){
                    System.out.print("ENTER YOUR LOGIN:");
                    String login = sc.next();
                    System.out.print("ENTER YOUR PASSWORD:");
                    String password = sc.next();
                    int errorCount = 0;
                    for (int i = 0; i < admins.size(); i++) {
                        errorCount++;
//___________________________________________________ADMINISTRATOR MODE__________________________________________________________________
                        if (admins.get(i).getLogin().compareTo(login) == 0 && admins.get(i).getPassword().compareTo(password)== 0){
                            errorCount = 0;
                            while (true){
                                System.out.println("PRESS [1] TO ADD MOVIE");
                                System.out.println("PRESS [2] TO DELETE MOVIE");
                                System.out.println("PRESS [3] TO GET LIST OF MOVIES");
                                System.out.println("PRESS [4] TO DELETE ACCOUNT");
                                System.out.println("PRESS [5] TO GET LIST OF ACCOUNTS");
                                System.out.println("PRESS [6] TO EXIT");
                                int choice1 = sc.nextInt();
                                if (choice1 == 1) {
                                    System.out.print("ENTER MOVIE NAME:");
                                    String name = sc.next();
                                    System.out.print("ENTER YEAR OF PRODUCTION:");
                                    int year = sc.nextInt();
                                    System.out.print("ENTER GENRE(S):");
                                    String genre = sc.next();
                                    System.out.print("ENTER COUNTRY:");
                                    String country = sc.next();
                                    System.out.print("ENTER DIRECTOR:");
                                    String director = sc.next();
                                    System.out.print("ENTER ACTOR(S):");
                                    String actor = sc.next();
                                    System.out.print("ENTER REVIEW:");
                                    String review = sc.next();
                                    System.out.print("ENTER LEVEL OF ACCESS(VIEWER-1/VIP VIEWER-2):");
                                    int level = sc.nextInt();
                                    String actorArray[] = actor.split(",");
                                    String genreArray[] = genre.split(",");
                                    ArrayList<Actor> actors = new ArrayList<>();
                                    ArrayList<Genre> genres = new ArrayList<>();
                                    if (level == 1) {
                                        for (int j = 0; j < actorArray.length; j++) {
                                            actors.add(new Actor(actorArray[j]));
                                        }
                                        for (int j = 0; j < genreArray.length; j++) {
                                            genres.add(new Genre(genreArray[j]));
                                        }
                                        movie = new RegularMovie();
                                        movie.setName(name);
                                        movie.setActors(actors);
                                        movie.setGenre(genres);
                                        movie.setCountry(country);
                                        movie.setDirector(new Director(director));
                                        movie.setRating(0);
                                        movie.setReview(review);
                                        movie.setYear(year);
                                        //movies.add(new RegularMovie(name, year, genres, country, 0, new Director(director), actors, review, 0));
                                        //String name, int year, String genre, String country, int rating, Director director, ArrayList<Actor> actors, String review, int rating_count
                                        saveRegularMovie(movie);
                                    } else if (level == 2) {
                                        for (int j = 0; j < actorArray.length; j++) {
                                            actors.add(new Actor(actorArray[j]));
                                        }
                                        for (int j = 0; j < genreArray.length; j++) {
                                            genres.add(new Genre(genreArray[j]));
                                        }
                                        vipMovie = new VIPMovie();
                                        vipMovie.setName(name);
                                        vipMovie.setActors(actors);
                                        vipMovie.setGenre(genres);
                                        vipMovie.setCountry(country);
                                        vipMovie.setDirector(new Director(director));
                                        vipMovie.setRating(0);
                                        vipMovie.setReview(review);
                                        vipMovie.setYear(year);
                                        saveVipMovie(vipMovie);
                                    }
                                }
                                else if (choice1 == 2){
                                    System.out.println("PRESS [1] TO DELETE MOVIE MOVIES WITHOUT SUBSCRIPTION:");
                                    System.out.println("PRESS [2] TO DELETE PREMIUM MOVIE");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1){
                                        System.out.println("MOVIES:");
                                        getRegularMovieList();
                                        movies = getRegularMovies();
                                        System.out.println("ENTER MOVIE INDEX:");
                                        int index = sc.nextInt();
                                        movies.remove(index);
                                        saveRegularMovies(movies);
                                        System.out.println("CHANGED MOVIE LIST:");
                                        getRegularMovieList();
                                    }
                                    if (choice2 == 2){
                                        System.out.println("PREMIUM MOVIES:");
                                        getVipMovieList();
                                        vipMovies = getVipMovies();
                                        int index = sc.nextInt();
                                        System.out.print("PRESS THE INDEX OF THE MOVIE TO DELETE:");

                                        saveVipMovies(vipMovies);
                                        System.out.println("CHANGED MOVIE LIST:");
                                        getVipMovieList();
                                    }
                                }else if (choice1 == 3){
                                    System.out.println("REGULAR MOVIES:");
                                    getRegularMovieList();
                                    System.out.println("PREMIUM MOVIES");
                                    getVipMovieList();
                                }else if(choice1 == 4){
                                    System.out.println("PRESS [1] TO DELETE REGULAR VIEWER");
                                    System.out.println("PRESS [2] TO DELETE VIP VIEWER");
                                    int choice2 = sc.nextInt();
                                    if (choice2 == 1){
                                        System.out.println("VIEWERS:");
                                        getRegularViewerList();
                                        viewers = getRegularViewer();
                                        System.out.println("ENTER VIEWER INDEX:");
                                        int index = sc.nextInt();
                                        viewers.remove(index);
                                        saveAccounts(viewers);
                                        System.out.println("CHANGED VIEWER LIST:");
                                        getRegularViewerList();
                                    }
                                    else if (choice2 == 2){
                                        System.out.println("VIEWERS:");
                                        getVipViewerList();
                                        vipViewers = getVipViewer();
                                        System.out.println("ENTER VIEWER INDEX:");
                                        int index = sc.nextInt();
                                        viewers = getRegularViewer();
                                        viewer = new Viewer();
                                        viewer.setLogin(vipViewers.get(index).getLogin());
                                        viewer.setPassword(vipViewers.get(index).getPassword());
                                        viewer.setWatched(vipViewers.get(index).getWatched());
                                        saveAccount(viewer);
                                        vipViewers.remove(index);
                                        saveVipAccounts(vipViewers);
                                    }
                                }
                                else if (choice1 == 5){
                                    getRegularViewerList();
                                }
                                else if (choice1 == 6){
                                    break;
                                }
                            }
                        }
                    }
//__________________________________________________END OF ADMISTRATOR MODE_________________________________________________________________
//____________________________________________________REGULAR VIEWER MODE___________________________________________________________________
                    viewers = getRegularViewer();
                    for (int i = 0; i < viewers.size(); i++) {
                        errorCount++;
                        if (viewers.get(i).getLogin().compareTo(login) == 0 && viewers.get(i).getPassword().compareTo(password) == 0){
                            errorCount = 0;
                            *//*for (int i = 0; i < admins.size(); i++) {
//___________________________________________________ADMINISTRATOR MODE__________________________________________________________________
                                if (admins.get(i).getLogin().compareTo(login) == 0 && admins.get(i).getPassword().compareTo(password)== 0){*//*
                            while (true){
                                System.out.println("PRESS [1] VIEW MOVIE LIST");
                                System.out.println("PRESS [2] TO SEARCH FOR MOVIE");
                                System.out.println("PRESS [3] TO FILTER MOVIE");
                                System.out.println("PRESS [4] TO RATE MOVIE");
                                System.out.println("PRESS [5] TO BUY SUBSCRIPTION");
                                System.out.println("PRESS [6] TO CHANGE PASSWORD");
                                System.out.println("PRESS [7] TO EXIT");
                                int choice1 = sc.nextInt();
                                if (choice1 == 1){
                                    getRegularMovieList();
                                    System.out.print("ENTER [-] TO EXIT OR ENTER INDEX TO WATCH MOVIE:");
                                    String choice2 = sc.next();
                                    if (choice2.compareTo("-") == 0){
                                        break;
                                    }
                                    else{
                                        int index = Integer.parseInt(choice2);
                                        movies = getRegularMovies();
                                        int count = 0;
                                        for (int j = 0; j < viewers.get(i).getWatched().size(); j++) {
                                            if (movies.get(index).getName().compareTo(viewers.get(i).getWatched().get(j).toString()) != 0){
                                                count++;
                                            }
                                        }
                                        if (count == viewers.get(i).getWatched().size()){
                                            viewers.get(i).addMovie(movies.get(index).getName());
                                            saveAccounts(viewers);
                                        }
                                        System.out.println("MOVIE NAME:" + movies.get(index).getName());
                                        System.out.println("Production year:" + movies.get(index).getYear());
                                        System.out.println("Genre:" + movies.get(index).getGenre());
                                        System.out.println("Country:" + movies.get(index).getCountry());
                                        System.out.println("Rating:" + movies.get(index).getRating());
                                        System.out.println("Director:" + movies.get(index).getDirector());
                                        System.out.println("Actors:" + movies.get(index).getActors());
                                        System.out.println("Review:");
                                        System.out.println(movies.get(index).getReview());
                                    }
                                }
                                else if (choice1 == 2){
                                    System.out.print("ENTER MOVIE NAME:");
                                    movies = getRegularMovies();
                                    String movieName = sc.next();
                                    int index = -1;
                                    for (int j = 0; j < movies.size(); j++) {
                                        if(movies.get(j).getName().compareTo(movieName) == 0){
                                            index = j;
                                        }
                                    }
                                    if (index == -1){
                                        System.out.println("NO AVAILABLE MOVIES");
                                    }
                                    else{
                                        System.out.println("MOVIE NAME:" + movies.get(index).getName());
                                        System.out.println("Production year:" + movies.get(index).getYear());
                                        System.out.println("Genre:" + movies.get(index).getGenre());
                                        System.out.println("Country:" + movies.get(index).getCountry());
                                        System.out.println("Rating:" + movies.get(index).getRating());
                                        System.out.println("Director:" + movies.get(index).getDirector());
                                        System.out.println("Actors:" + movies.get(index).getActors());
                                        System.out.println("Review:");
                                        System.out.println(movies.get(index).getReview());
                                        System.out.println("PRESS [1] TO WATCH OR [0] TO EXIT");
                                        int choice2 = sc.nextInt();
                                        if (choice2 == 1){
                                            int count = 0;
                                            for (int j = 0; j < viewers.get(i).getWatched().size(); j++) {
                                                if (movies.get(index).getName().compareTo(viewers.get(i).getWatched().get(j).toString()) != 0){
                                                    count++;
                                                }
                                            }
                                            if (count == viewers.get(i).getWatched().size()){
                                                viewers.get(i).addMovie(movies.get(index).getName());
                                                saveAccounts(viewers);
                                            }
                                        }
                                    }

                                }
                                else if (choice1 == 3){
                                    while (true) {
                                        System.out.println("PRESS [1] TO FILTER BY GENRE");
                                        System.out.println("PRESS [2] TO FILTER BY STARRING ACTOR");
                                        System.out.println("PRESS [3] TO FILTER BY PRODUCTION YEAR");
                                        System.out.println("PRESS [4] TO FILTER BY RATING");
                                        System.out.println("PRESS [5] TO FILTER BY COUNTRY");
                                        System.out.println("PRESS [6] TO EXIT");
                                        int choice2 = sc.nextInt();
                                        if (choice2 == 1) {
                                            System.out.print("ENTER GENRE YOU LIKE:");
                                            String chosenGenre = sc.next();
                                            movies = getRegularMovies();
                                            for (int j = 0; j < movies.size(); j++) {
                                                for (int k = 0; k < movies.get(j).getGenre().size(); k++) {
                                                    if (movies.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0) {
                                                        System.out.println(movies.get(j).getInfo());
                                                    }
                                                }
                                            }
                                        } else if (choice2 == 2) {
                                            System.out.print("ENTER ACTOR YOU LIKE:");
                                            String chosenActor = sc.next();
                                            movies = getRegularMovies();
                                            for (int j = 0; j < movies.size(); j++) {
                                                for (int k = 0; k < movies.get(j).getActors().size(); k++) {
                                                    if (movies.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0) {
                                                        System.out.println(movies.get(j).getInfo());
                                                    }
                                                }
                                            }
                                        } else if (choice2 == 3) {
                                            System.out.print("ENTER MINIMAL YEAR OF PRODUCTION:");
                                            int chosenYear = sc.nextInt();
                                            movies = getRegularMovies();
                                            for (int j = 0; j < movies.size(); j++) {
                                                if (movies.get(j).getYear() >= chosenYear) {
                                                    System.out.println(movies.get(j).getInfo());
                                                }

                                            }
                                        } else if (choice2 == 4) {
                                            System.out.print("ENTER MINIMAL MOVIE RATING:");
                                            double chosenRating = sc.nextDouble();
                                            movies = getRegularMovies();
                                            for (int j = 0; j < movies.size(); j++) {
                                                if (movies.get(j).getRating() >= chosenRating) {
                                                    System.out.println(movies.get(j).getInfo());
                                                }
                                            }
                                        } else if (choice2 == 5) {
                                            System.out.print("ENTER COUNTRY:");
                                            String chosenCountry = sc.next();
                                            movies = getRegularMovies();
                                            for (int j = 0; j < movies.size(); j++) {
                                                if (movies.get(j).getCountry().compareTo(chosenCountry) == 0) {
                                                    System.out.println(movies.get(j).getInfo());
                                                }
                                            }
                                        } else if (choice2 == 6) {
                                            break;
                                        }
                                    }
                                }
                                else if (choice1 == 4){
                                    System.out.println(viewers.get(i).getWatched());
                                    System.out.print("ENTER NAME OF THE MOVIE YOU WANT TO RATE:");
                                    String name = sc.next();
                                    System.out.print("ENTER YOUR RATE:");
                                    double rate = sc.nextDouble();
                                    movies = getRegularMovies();
                                    for (int j = 0; j < movies.size(); j++) {
                                        if (movies.get(j).getName().compareTo(name) == 0){
                                            movies.get(j).rateMovie(rate);
                                            saveRegularMovies(movies);
                                        }
                                    }
                                }
                                else if (choice1 == 5){
                                    vipViewer = new VIPviewer();
                                    vipViewer.setLogin(viewers.get(i).getLogin());
                                    vipViewer.setPassword(viewers.get(i).getPassword());
                                    vipViewer.setWatched(viewers.get(i).getWatched());
                                    saveVipAccount(vipViewer);
                                    viewers = getRegularViewer();
                                    viewers.remove(i);
                                    saveAccounts(viewers);
                                    System.out.println("YOU HAVE SUCCESSFULLY WENT TO A PREMIUM SUBSCRIPTION!");
                                    System.out.println("PLEASE LOG IN AGAN TO YOUR ACCOUNT!");
                                    break;
                                }
                                else if (choice1 == 6){
                                    System.out.print("INSERT YOUR NEW PASSWORD:");
                                    String newPassword = sc.next();
                                    viewers.get(i).setPassword(newPassword);
                                    saveAccounts(viewers);
                                    System.out.println("SUCCESFULLY CHAMGED!");
                                }
                                else if (choice1 == 7){
                                    break;
                                }
                            }
                        }
                    }
//__________________________________________________END OF REGULAR VIEWER MODE______________________________________________________________
                    //viewers = getVViewer()
                    vipViewers = getVipViewer();
                    for (int i = 0; i < vipViewers.size(); i++) {
                        errorCount++;
//_______________________________________________________VIP VIEWER MODE____________________________________________________________________
                        if (vipViewers.get(i).getLogin().compareTo(login) == 0 && vipViewers.get(i).getPassword().compareTo(password) == 0){
                            errorCount = 0;
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                allMovie.add(movies.get(j));
                            }
                            vipMovies = getVipMovies();
                            for (int j = 0; j < vipMovies.size(); j++) {
                                allMovie.add(vipMovies.get(j));
                            }
                            while (true){
                                System.out.println("PRESS [1] VIEW MOVIE LIST");
                                System.out.println("PRESS [2] TO SEARCH FOR MOVIE");
                                System.out.println("PRESS [3] TO FILTER MOVIE");
                                System.out.println("PRESS [4] TO RATE WATCHED MOVIE");
                                System.out.println("PRESS [5] TO VIEW RECOMMENDATIONS");
                                System.out.println("PRESS [6] CHANGE PASSWORD");
                                System.out.println("PRESS [7] TO EXIT");
                                int choice1 = sc.nextInt();
                                if (choice1 == 1){
                                    for (int j = 0; j < allMovie.size(); j++) {
                                        if (allMovie.get(j) instanceof RegularMovie){
                                            System.out.println("Regular: ["  + j + "]" + allMovie.get(j));
                                        }
                                        else if(allMovie.get(j) instanceof  VIPMovie){
                                            System.out.println("Premium: [" + j + "]" + allMovie.get(j));
                                        }
                                    }
                                    System.out.print("ENTER [-] TO EXIT OR ENTER INDEX TO WATCH MOVIE:");
                                    String choice2 = sc.next();
                                    if (choice2.compareTo("-") == 0){
                                        break;
                                    }
                                    else{
                                        int index = Integer.parseInt(choice2);

                                        if (index >= movies.size()){
                                            System.out.println(movies.size());
                                            index = index - movies.size();
                                            System.out.println(index);
                                            int count = 0;
                                            for (int j = 0; j < vipViewers.get(i).getWatched().size(); j++) {
                                                if (vipMovies.get(index).getName().compareTo(vipViewers.get(i).getWatched().get(j).toString()) != 0){
                                                    count++;
                                                }
                                            }
                                            if (count == vipViewers.get(i).getWatched().size()){
                                                vipViewers.get(i).addMovie(vipMovies.get(index).getName());
                                                saveVipAccounts(vipViewers);
                                            }
                                            System.out.println("MOVIE NAME:" + vipMovies.get(index).getName());
                                            System.out.println("Production year:" + vipMovies.get(index).getYear());
                                            System.out.println("Genre:" + vipMovies.get(index).getGenre());
                                            System.out.println("Country:" + vipMovies.get(index).getCountry());
                                            System.out.println("Rating:" + vipMovies.get(index).getRating());
                                            System.out.println("Director:" + vipMovies.get(index).getDirector());
                                            System.out.println("Actors:" + vipMovies.get(index).getActors());
                                            System.out.println("Review:");
                                            System.out.println(vipMovies.get(index).getReview());
                                        }
                                        else {
                                            int count = 0;
                                            for (int j = 0; j < vipViewers.get(i).getWatched().size(); j++) {
                                                if (movies.get(index).getName().compareTo(viewers.get(i).getWatched().get(j).toString()) != 0){
                                                    count++;
                                                }
                                            }
                                            if (count == vipViewers.get(i).getWatched().size()){
                                                vipViewers.get(i).addMovie(movies.get(index).getName());
                                                saveVipAccounts(vipViewers);
                                            }
                                            System.out.println("MOVIE NAME:" + movies.get(index).getName());
                                            System.out.println("Production year:" + movies.get(index).getYear());
                                            System.out.println("Genre:" + movies.get(index).getGenre());
                                            System.out.println("Country:" + movies.get(index).getCountry());
                                            System.out.println("Rating:" + movies.get(index).getRating());
                                            System.out.println("Director:" + movies.get(index).getDirector());
                                            System.out.println("Actors:" + movies.get(index).getActors());
                                            System.out.println("Review:");
                                            System.out.println(movies.get(index).getReview());
                                        }

                                    }
                                }
                                else if (choice1 == 2){
                                    System.out.print("ENTER MOVIE NAME:");
                                    String movieName = sc.next();
                                    int index = -1;
                                    for (int j = 0; j < movies.size(); j++) {
                                        if(movies.get(j).getName().compareTo(movieName) == 0){
                                            index = j;
                                            System.out.println("MOVIE NAME:" + movies.get(index).getName());
                                            System.out.println("Production year:" + movies.get(index).getYear());
                                            System.out.println("Genre:" + movies.get(index).getGenre());
                                            System.out.println("Country:" + movies.get(index).getCountry());
                                            System.out.println("Rating:" + movies.get(index).getRating());
                                            System.out.println("Director:" + movies.get(index).getDirector());
                                            System.out.println("Actors:" + movies.get(index).getActors());
                                            System.out.println("Review:");
                                            System.out.println(movies.get(index).getReview());
                                            System.out.println("PRESS [1] TO WATCH OR [0] TO EXIT");
                                            int choice2 = sc.nextInt();
                                            if (choice2 == 1){
                                                int count = 0;
                                                for (int k = 0; k < vipViewers.get(i).getWatched().size(); k++) {
                                                    if (movies.get(index).getName().compareTo(vipViewers.get(i).getWatched().get(k).toString()) != 0){
                                                        count++;
                                                    }
                                                }
                                                if (count == vipViewers.get(i).getWatched().size()){
                                                    vipViewers.get(i).addMovie(movies.get(index).getName());
                                                    saveAccounts(viewers);
                                                }
                                            }
                                        }
                                    }
                                    for (int j = 0; j < vipMovies.size(); j++) {
                                        if (vipMovies.get(j).getName().compareTo(movieName) == 0){
                                            index = j;
                                            System.out.println("MOVIE NAME:" + vipMovies.get(index).getName());
                                            System.out.println("Production year:" + vipMovies.get(index).getYear());
                                            System.out.println("Genre:" + vipMovies.get(index).getGenre());
                                            System.out.println("Country:" + vipMovies.get(index).getCountry());
                                            System.out.println("Rating:" + vipMovies.get(index).getRating());
                                            System.out.println("Director:" + vipMovies.get(index).getDirector());
                                            System.out.println("Actors:" + vipMovies.get(index).getActors());
                                            System.out.println("Review:");
                                            System.out.println(vipMovies.get(index).getReview());
                                            System.out.println("PRESS [1] TO WATCH OR [0] TO EXIT");
                                            int choice2 = sc.nextInt();
                                            if (choice2 == 1){
                                                int count = 0;
                                                for (int k = 0; k < vipViewers.get(i).getWatched().size(); k++) {
                                                    if (vipMovies.get(index).getName().compareTo(vipViewers.get(i).getWatched().get(k).toString()) != 0){
                                                        count++;
                                                    }
                                                }
                                                if (count == vipViewers.get(i).getWatched().size()){
                                                    vipViewers.get(i).addMovie(vipMovies.get(index).getName());
                                                    saveAccounts(viewers);
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    if (index == -1) {
                                        System.out.println("NO AVAILABLE MOVIES");
                                    }
                                }
                                else if (choice1 == 3){
                                    while (true) {
                                        System.out.println("PRESS [1] TO FILTER BY GENRE");
                                        System.out.println("PRESS [2] TO FILTER BY STARRING ACTOR");
                                        System.out.println("PRESS [3] TO FILTER BY PRODUCTION YEAR");
                                        System.out.println("PRESS [4] TO FILTER BY RATING");
                                        System.out.println("PRESS [5] TO FILTER BY COUNTRY");
                                        System.out.println("PRESS [6] TO EXIT");
                                        int choice2 = sc.nextInt();
                                        if (choice2 == 1) {
                                            System.out.print("ENTER GENRE YOU LIKE:");
                                            String chosenGenre = sc.next();
                                            for (int j = 0; j < allMovie.size(); j++) {
                                                for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                    if (allMovie.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0 && allMovie.get(j) instanceof RegularMovie) {
                                                        System.out.println("Regular:" + allMovie.get(j).getInfo());
                                                    }
                                                    else if (allMovie.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0 && allMovie.get(j) instanceof VIPMovie) {
                                                        System.out.println("Premium:" + allMovie.get(j).getInfo());
                                                    }
                                                }
                                            }
                                        } else if (choice2 == 2) {
                                            System.out.print("ENTER ACTOR YOU LIKE:");
                                            String chosenActor = sc.next();
                                            for (int j = 0; j < allMovie.size(); j++) {
                                                for (int k = 0; k < allMovie.get(j).getActors().size(); k++) {
                                                    if (allMovie.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0 && allMovie.get(j) instanceof RegularMovie) {
                                                        System.out.println("Regular:" + allMovie.get(j).getInfo());
                                                    }
                                                    else if (allMovie.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0 && allMovie.get(j) instanceof VIPMovie) {
                                                        System.out.println("Premium:" + allMovie.get(j).getInfo());
                                                    }
                                                }
                                            }
                                        }
                                        else if (choice2 == 3) {
                                            System.out.print("ENTER MINIMAL YEAR OF PRODUCTION:");
                                            int chosenYear = sc.nextInt();
                                            for (int j = 0; j < allMovie.size(); j++) {
                                                if (allMovie.get(j).getYear() >= chosenYear && allMovie.get(j) instanceof RegularMovie) {
                                                    System.out.println("Regular:" + allMovie.get(j).getInfo());
                                                }
                                                else if (allMovie.get(j).getYear() >= chosenYear && allMovie.get(j) instanceof VIPMovie) {
                                                    System.out.println("Premium:" + allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                        else if (choice2 == 4) {
                                            System.out.print("ENTER MINIMAL MOVIE RATING:");
                                            double chosenRating = sc.nextDouble();
                                            for (int j = 0; j < allMovie.size(); j++) {
                                                if (allMovie.get(j).getRating() >= chosenRating && allMovie.get(j) instanceof RegularMovie) {
                                                    System.out.println("Regular:" + allMovie.get(j).getInfo());
                                                }else if (allMovie.get(j).getRating() >= chosenRating && allMovie.get(j) instanceof VIPMovie) {
                                                    System.out.println("Premium:" + allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                        else if (choice2 == 5) {
                                            System.out.print("ENTER COUNTRY:");
                                            String chosenCountry = sc.next();
                                            for (int j = 0; j < allMovie.size(); j++) {
                                                if (allMovie.get(j).getCountry().compareTo(chosenCountry) == 0 && allMovie.get(j) instanceof RegularMovie) {
                                                    System.out.println("Regular:" + allMovie.get(j).getInfo());
                                                }else if (allMovie.get(j).getCountry().compareTo(chosenCountry) == 0 && allMovie.get(j) instanceof VIPMovie) {
                                                    System.out.println("Premium:" + allMovie.get(j).getInfo());
                                                }
                                            }
                                        } else if (choice2 == 6) {
                                            break;
                                        }
                                    }
                                }
                                else if (choice1 == 4){
                                    System.out.println(vipViewers.get(i).getWatched());
                                    System.out.print("ENTER NAME OF THE MOVIE YOU WANT TO RATE:");
                                    String name = sc.next();
                                    System.out.print("ENTER YOUR RATE:");
                                    double rate = sc.nextDouble();
                                    for (int j = 0; j < movies.size(); j++) {
                                        if (movies.get(j).getName().compareTo(name) == 0){
                                            movies.get(j).rateMovie(rate);
                                            saveRegularMovies(movies);
                                        }
                                    }
                                    for (int j = 0; j < vipMovies.size(); j++) {
                                        if (vipMovies.get(j).getName().compareTo(name) == 0){
                                            vipMovies.get(j).rateMovie(rate);
                                            saveVipMovies(vipMovies);
                                        }
                                    }
                                }
                                else if (choice1 == 5){
                                    int comedyCount = 0, romanceCount=0, adventureCount = 0, fantasyCount = 0, horrorCount = 0, dramaCount = 0;
                                    int thrillerCount = 0, actionCount = 0, bioCount = 0, crimeCount = 0;
                                    int arr[];
                                    for (int j = 0; j < vipViewers.get(i).getWatched().size(); j++) {
                                        if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Comedy") == 0){
                                            comedyCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Romance") == 0){
                                            romanceCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Adventure") == 0){
                                            adventureCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Fantasy") == 0){
                                            fantasyCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Horror") == 0){
                                            horrorCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Drama") == 0){
                                            dramaCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Thriller") == 0){
                                            thrillerCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Action") == 0){
                                            actionCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Biography") == 0){
                                            bioCount++;
                                        }else if (vipViewers.get(i).getWatched().get(j).getName().compareTo("Crime") == 0){
                                            crimeCount++;
                                        }
                                    }
                                    if (comedyCount >= romanceCount && comedyCount >= adventureCount && comedyCount >= fantasyCount && comedyCount >= dramaCount &&
                                            comedyCount >= thrillerCount && comedyCount >= actionCount && comedyCount >= bioCount && comedyCount >= crimeCount && comedyCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Comedy") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (romanceCount >= comedyCount && romanceCount >= adventureCount && romanceCount >= fantasyCount && romanceCount >= dramaCount &&
                                            romanceCount >= thrillerCount && romanceCount >= actionCount && romanceCount >= bioCount && romanceCount >= crimeCount && romanceCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Romance") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (adventureCount >= comedyCount && adventureCount >= romanceCount && adventureCount >= fantasyCount && adventureCount >= dramaCount &&
                                            adventureCount >= thrillerCount && adventureCount >= actionCount && adventureCount >= bioCount && adventureCount >= crimeCount && adventureCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Adventure") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (fantasyCount >= comedyCount && fantasyCount >= adventureCount && fantasyCount >= romanceCount && fantasyCount >= dramaCount &&
                                            fantasyCount >= thrillerCount && fantasyCount >= actionCount && fantasyCount >= bioCount && fantasyCount >= crimeCount && fantasyCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Fantasy") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (dramaCount >= comedyCount && dramaCount >= adventureCount && dramaCount >= fantasyCount && dramaCount >= romanceCount &&
                                            dramaCount >= thrillerCount && dramaCount >= actionCount && dramaCount >= bioCount && dramaCount >= crimeCount && dramaCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Drama") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (thrillerCount >= comedyCount && thrillerCount >= adventureCount && thrillerCount >= fantasyCount && thrillerCount >= dramaCount &&
                                            thrillerCount >= romanceCount && thrillerCount >= actionCount && thrillerCount >= bioCount && thrillerCount >= crimeCount && thrillerCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Thriller") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (actionCount >= comedyCount && actionCount >= adventureCount && actionCount >= fantasyCount && actionCount >= dramaCount &&
                                            actionCount >= romanceCount && actionCount >= thrillerCount && actionCount >= bioCount && actionCount >= crimeCount && actionCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Action") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (bioCount >= comedyCount && bioCount >= adventureCount && bioCount >= fantasyCount && bioCount >= dramaCount &&
                                            bioCount >= romanceCount && bioCount >= actionCount && bioCount >= thrillerCount && bioCount >= crimeCount && bioCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Biography") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }else if (crimeCount >= comedyCount && crimeCount >= adventureCount && crimeCount >= fantasyCount && crimeCount >= dramaCount &&
                                            crimeCount >= romanceCount && crimeCount >= actionCount && crimeCount >= bioCount && crimeCount >= thrillerCount && crimeCount >= horrorCount){
                                        for (int j = 0; j < allMovie.size(); j++) {
                                            for (int k = 0; k < allMovie.get(j).getGenre().size(); k++) {
                                                if (allMovie.get(j).getGenre().get(k).getName().compareTo("Crime") == 0){
                                                    System.out.println(allMovie.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }
                                }
                                else if (choice1 == 6){
                                    System.out.print("INSERT YOUR NEW PASSWORD:");
                                    String newPassword = sc.next();
                                    vipViewers.get(i).setPassword(newPassword);
                                    saveVipAccounts(vipViewers);
                                    System.out.println("SUCCESFULLY CHAMGED!");
                                }
                                else if (choice1 == 7){
                                    break;
                                }
                            }
                        }
                    }
                    if (errorCount == admins.size() + viewers.size() + vipViewers.size()){
                        System.out.println("WRONG LOGIN OR PASSWORD!!!");
                    }
                }

//_________________________________________________________REGISTRATION_____________________________________________________________________
                else if(choice == 2){
                    System.out.print("ENTER LOGIN:");
                    String login = sc.next();
                    System.out.print("ENTER PASSWORD:");
                    String password = sc.next();
                    viewer = new Viewer();
                    viewer.setLogin(login);
                    viewer.setPassword(password);
                    viewer.setWatched(null);
                    saveAccount(viewer);
                    viewers = getRegularViewer();
                    saveAccounts(viewers);
                    System.out.println("YOU ARE REGISTERED! PLEASE LOG IN YOUR ACCOUNT");
                    System.out.print("WOULD YOU LIKE TO UPGRADE YOUR ACCOUNT(yes|no)?");
                    String choice1 = sc.next();
                    if (choice1.compareTo("yes") == 0){
                        vipViewer = new VIPviewer();
                        vipViewer.setLogin(login);
                        vipViewer.setPassword(password);
                        vipViewer.setWatched(null);
                        saveVipAccount(vipViewer);
                        //vipViewers = getVipViewer();
                        viewers = getRegularViewer();
                        for (int i = 0; i < viewers.size(); i++) {
                            if (viewers.get(i).getLogin().compareTo(viewer.getLogin()) == 0){
                                viewers.remove(i);
                            }
                        }
                        saveAccounts(viewers);
                        System.out.println("YOU HAVE SUCCESSFULLY WENT TO A PREMIUM SUBSCRIPTION!");

                    }else if(choice1.compareTo("no") == 0){
                        break;
                    }
                    System.out.println("PLEASE LOG IN YOUR ACCOUNT");

                }
                else if(choice == 3){
                    System.out.println("AVAILABLE MOVIES:");
                    getRegularMovieList();
                }
                else if (choice == 4){
                    System.out.print("ENTER MOVIE NAME:");
                    movies = getRegularMovies();
                    String movieName = sc.next();
                    int index = -1;
                    for (int j = 0; j < movies.size(); j++) {
                        if(movies.get(j).getName().compareTo(movieName) == 0){
                            index = j;
                        }
                    }
                    if (index == -1){
                        System.out.println("NO AVAILABLE MOVIES");
                    }
                    else{
                        System.out.println("MOVIE NAME:" + movies.get(index).getName());
                        System.out.println("Production year:" + movies.get(index).getYear());
                        System.out.println("Genre:" + movies.get(index).getGenre());
                        System.out.println("Country:" + movies.get(index).getCountry());
                        System.out.println("Rating:" + movies.get(index).getRating());
                        System.out.println("Director:" + movies.get(index).getDirector());
                        System.out.println("Actors:" + movies.get(index).getActors());
                        System.out.println("Review:");
                        System.out.println(movies.get(index).getReview());
                    }
                }
                else if (choice == 5){
                    while (true) {
                        System.out.println("PRESS [1] TO FILTER BY GENRE");
                        System.out.println("PRESS [2] TO FILTER BY STARRING ACTOR");
                        System.out.println("PRESS [3] TO FILTER BY PRODUCTION YEAR");
                        System.out.println("PRESS [4] TO FILTER BY RATING");
                        System.out.println("PRESS [5] TO FILTER BY COUNTRY");
                        System.out.println("PRESS [6] TO FILTER BY ALL CHARACTERISRICS");
                        System.out.println("PRESS [7] TO EXIT");
                        int choice2 = sc.nextInt();
                        if (choice2 == 1) {
                            System.out.print("ENTER GENRE YOU LIKE:");
                            String chosenGenre = sc.next();
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                for (int k = 0; k < movies.get(j).getGenre().size(); k++) {
                                    if (movies.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0) {
                                        System.out.println(movies.get(j).getInfo());
                                    }
                                }
                            }
                        } else if (choice2 == 2) {
                            System.out.print("ENTER ACTOR YOU LIKE:");
                            String chosenActor = sc.next();
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                for (int k = 0; k < movies.get(j).getActors().size(); k++) {
                                    if (movies.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0) {
                                        System.out.println(movies.get(j).getInfo());
                                    }
                                }
                            }
                        } else if (choice2 == 3) {
                            System.out.print("ENTER MINIMAL YEAR OF PRODUCTION:");
                            int chosenYear = sc.nextInt();
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                if (movies.get(j).getYear() >= chosenYear) {
                                    System.out.println(movies.get(j).getInfo());
                                }

                            }
                        } else if (choice2 == 4) {
                            System.out.print("ENTER MINIMAL MOVIE RATING:");
                            double chosenRating = sc.nextDouble();
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                if (movies.get(j).getRating() >= chosenRating) {
                                    System.out.println(movies.get(j).getInfo());
                                }
                            }
                        } else if (choice2 == 5) {
                            System.out.print("ENTER COUNTRY:");
                            String chosenCountry = sc.next();
                            movies = getRegularMovies();
                            for (int j = 0; j < movies.size(); j++) {
                                if (movies.get(j).getCountry().compareTo(chosenCountry) == 0) {
                                    System.out.println(movies.get(j).getInfo());
                                }
                            }
                        } else if (choice2 == 6){
                            String chosenGenre = sc.next();
                            String chosenActor = sc.next();
                            int chosenYear = sc.nextInt();
                            double chosenRating = sc.nextDouble();
                            String chosenCountry = sc.next();
                            movies = getRegularMovies();

                            for (int j = 0; j < movies.size(); j++) {
                                if (chosenGenre.compareTo("None") == 0){
                                    if (chosenActor.compareTo("None") == 0){
                                        if (movies.get(j).getYear() >= chosenYear){
                                            if (movies.get(j).getRating() >= chosenRating){
                                                if (chosenCountry.compareTo("None") == 0){
                                                    System.out.println(movies.get(j).getInfo());
                                                }
                                                else if (movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                    System.out.println(movies.get(j).getInfo());
                                                }
                                            }
                                        }
                                    }
                                    else{
                                        for (int k = 0; k < movies.get(j).getActors().size(); k++) {
                                            if (movies.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0) {
                                                if (movies.get(j).getYear() >= chosenYear){
                                                    if (movies.get(j).getRating() >= chosenRating){
                                                        if (chosenCountry.compareTo("None") == 0){
                                                            System.out.println(movies.get(j).getInfo());
                                                        }
                                                        else if (movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                            System.out.println(movies.get(j).getInfo());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    for (int k = 0; k < movies.get(j).getGenre().size(); k++) {
                                        if (movies.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0){
                                            if (chosenActor.compareTo("None") == 0){
                                                if (movies.get(j).getYear() >= chosenYear){
                                                    if (movies.get(j).getRating() >= chosenRating){
                                                        if (chosenCountry.compareTo("None") == 0){
                                                            System.out.println(movies.get(j).getInfo());
                                                        }
                                                        else if (movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                            System.out.println(movies.get(j).getInfo());
                                                        }
                                                    }
                                                }
                                            }
                                            else{
                                                for (int l = 0; l < movies.get(j).getActors().size(); l++) {
                                                    if (movies.get(j).getActors().get(l).getName().compareTo(chosenActor) == 0) {
                                                        if (movies.get(j).getYear() >= chosenYear){
                                                            if (movies.get(j).getRating() >= chosenRating){
                                                                if (chosenCountry.compareTo("None") == 0){
                                                                    System.out.println(movies.get(j).getInfo());
                                                                }
                                                                else if (movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                                    System.out.println(movies.get(j).getInfo());
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                        else if (choice2 == 7) {
                            break;
                        }
                    }
                }
                else if(choice == 6){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getRegularMovieList () {
        RegularMovie movie = null;
        ArrayList<RegularMovie> movies = null;
        BufferedReader read = null;
        try{
            read = new BufferedReader(new FileReader("regularMovie.txt"));
            String text = "";
            movies = new ArrayList<>();
            while ((text = read.readLine())!= null){
                movie = new RegularMovie();
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String arr[] = text.split("\\|");
                arr[6] =arr[6].toString().replace("[", "").replace("]", "");
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String actor[] = arr[6].split(", ");
                String genre[] = arr[2].split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                movie = new RegularMovie();
                movie.setName(arr[0]);
                movie.setActors(actors);
                movie.setGenre(genres);
                movie.setCountry(arr[3]);
                movie.setDirector(new Director(arr[5]));
                movie.setRating(Double.parseDouble(arr[4]));
                movie.setReview(arr[7]);
                movie.setYear(Integer.parseInt(arr[1]));
                movie.setRating_count(Integer.parseInt(arr[8]));
                movies.add(movie);
                //movies.add(new RegularMovie(arr[0], Integer.parseInt(arr[1]), genres, arr[3], Double.parseDouble(arr[4]), new Director(arr[5]), actors, arr[7], Integer.parseInt(arr[8])));
                //name + " " + year + " " + genre + " " + country + " " + rating + " " + director + " " + actors + " " + review
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("[" + i + "] " + movies.get(i).getInfo());
            System.out.println("________________________________________________________________");
        }
    }

    public static ArrayList<RegularMovie> getRegularMovies () {
        RegularMovie movie = null;
        ArrayList<RegularMovie> movies = null;
        BufferedReader read = null;
        try{
            read = new BufferedReader(new FileReader("regularMovie.txt"));
            String text = "";
            movies = new ArrayList<>();
            movie = new RegularMovie();
            while ((text = read.readLine())!= null){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String arr[] = text.split("\\|");
                arr[6] =arr[6].toString().replace("[", "").replace("]", "");
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String actor[] = arr[6].split(", ");
                String genre[] = arr[2].split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                movie = new RegularMovie();
                movie.setName(arr[0]);
                movie.setActors(actors);
                movie.setGenre(genres);
                movie.setCountry(arr[3]);
                movie.setDirector(new Director(arr[5]));
                movie.setRating(Double.parseDouble(arr[4]));
                movie.setReview(arr[7]);
                movie.setYear(Integer.parseInt(arr[1]));
                movie.setRating_count(Integer.parseInt(arr[8]));
                movies.add(movie);
                //movies.add(new RegularMovie(arr[0], Integer.parseInt(arr[1]), genres, arr[3], Double.parseDouble(arr[4]), new Director(arr[5]), actors, arr[7], Integer.parseInt(arr[8])));
                //name + " " + year + " " + genre + " " + country + " " + rating + " " + director + " " + actors + " " + review
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return movies;
    }

    public static void getVipMovieList () {
        VIPMovie vipMovie = null;
        ArrayList<VIPMovie> vipMovies = null;
        BufferedReader read = null;
        try{
            read = new BufferedReader(new FileReader("vipMovie.txt"));
            String text = "";
            vipMovies = new ArrayList<>();
            while ((text = read.readLine())!= null){
                vipMovie = new VIPMovie();
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String arr[] = text.split("\\|");
                arr[6] =arr[6].toString().replace("[", "").replace("]", "");
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String actor[] = arr[6].split(", ");
                String genre[] = arr[2].split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                vipMovie = new VIPMovie();
                vipMovie.setName(arr[0]);
                vipMovie.setActors(actors);
                vipMovie.setGenre(genres);
                vipMovie.setCountry(arr[3]);
                vipMovie.setDirector(new Director(arr[5]));
                vipMovie.setRating(Double.parseDouble(arr[4]));
                vipMovie.setReview(arr[7]);
                vipMovie.setYear(Integer.parseInt(arr[1]));
                vipMovie.setRating_count(Integer.parseInt(arr[8]));
                vipMovies.add(vipMovie);
                //movies.add(new RegularMovie(arr[0], Integer.parseInt(arr[1]), genres, arr[3], Double.parseDouble(arr[4]), new Director(arr[5]), actors, arr[7], Integer.parseInt(arr[8])));
                //name + " " + year + " " + genre + " " + country + " " + rating + " " + director + " " + actors + " " + review
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < vipMovies.size(); i++) {
            System.out.println("[" + i + "] " + vipMovies.get(i).getInfo());
            System.out.println("________________________________________________________________");
        }
    }

    public static ArrayList<VIPMovie> getVipMovies () {
        VIPMovie vipMovie = null;
        ArrayList<VIPMovie> vipMovies = null;
        BufferedReader read = null;
        try{
            read = new BufferedReader(new FileReader("vipMovie.txt"));
            String text = "";
            vipMovies = new ArrayList<>();
            vipMovie = new VIPMovie();

            while ((text = read.readLine())!= null){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String arr[] = text.split("\\|");
                arr[6] =arr[6].toString().replace("[", "").replace("]", "");
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String actor[] = arr[6].split(", ");
                String genre[] = arr[2].split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                vipMovie = new VIPMovie();
                vipMovie.setName(arr[0]);
                vipMovie.setActors(actors);
                vipMovie.setGenre(genres);
                vipMovie.setCountry(arr[3]);
                vipMovie.setDirector(new Director(arr[5]));
                vipMovie.setRating(Double.parseDouble(arr[4]));
                vipMovie.setReview(arr[7]);
                vipMovie.setYear(Integer.parseInt(arr[1]));
                vipMovie.setRating_count(Integer.parseInt(arr[8]));
                vipMovies.add(vipMovie);
                //movies.add(new RegularMovie(arr[0], Integer.parseInt(arr[1]), genres, arr[3], Double.parseDouble(arr[4]), new Director(arr[5]), actors, arr[7], Integer.parseInt(arr[8])));
                //name + " " + year + " " + genre + " " + country + " " + rating + " " + director + " " + actors + " " + review
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return vipMovies;
    }

    public static void saveRegularMovies (ArrayList<RegularMovie> movies) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("regularMovie.txt"));
            for (Movie movie:movies){
                write.write(movie.toString() + "\n");
            }
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveRegularMovie (RegularMovie movies) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("regularMovie.txt", true));
            write.write(movies.toString() + "\n");
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveVipMovies (ArrayList<VIPMovie> movies) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("vipMovie.txt"));
            for (Movie movie:movies){
                write.write(movie.toString() + "\n");
            }
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveVipMovie (VIPMovie movies) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("vipMovie.txt", true));
            write.write(movies.toString() + "\n");
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveAccount (Viewer viewer) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("regularViewer.txt", true));
            write.write(viewer.toString() + "\n");
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveVipAccount (VIPviewer viewer) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("vipViewer.txt", true));
            write.write(viewer.toString() + "\n");
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveAccounts (ArrayList<Viewer> viewers) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("regularViewer.txt"));
            for (Viewer viewer:viewers){
                write.write(viewer.toString() + "\n");
            }
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void saveVipAccounts (ArrayList<VIPviewer> viewers) {
        BufferedWriter write = null;
        try {
            write = new BufferedWriter(new FileWriter("vipViewer.txt"));
            for (VIPviewer viewer:viewers){
                write.write(viewer.toString() + "\n");
            }
            write.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Viewer> getRegularViewer () {
        ArrayList<Viewer> viewers = null;
        BufferedReader read = null;
        Viewer viewer = null;
        try{
            read = new BufferedReader(new FileReader("regularViewer.txt"));
            String text = "";
            viewers = new ArrayList<>();
            while ((text = read.readLine())!= null){
                viewer = new Viewer();
                ArrayList<String> watched = new ArrayList<>();
                String arr[] = text.split("\\|");
                viewer.setLogin(arr[0]);
                viewer.setPassword(arr[1]);
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String movies[] = arr[2].split(", ");
                for (int i = 0; i < movies.length; i++) {
                    watched.add(new String(movies[i]));
                }
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewers;
    }

    public static ArrayList<VIPviewer> getVipViewer () {
        ArrayList<VIPviewer> viewers = null;
        BufferedReader read = null;
        VIPviewer viewer = null;
        try{
            read = new BufferedReader(new FileReader("vipViewer.txt"));
            String text = "";
            viewers = new ArrayList<>();
            while ((text = read.readLine())!= null){
                viewer = new VIPviewer();
                ArrayList<String> watched = new ArrayList<>();
                String arr[] = text.split("\\|");
                viewer.setLogin(arr[0]);
                viewer.setPassword(arr[1]);
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String movies[] = arr[2].split(", ");
                for (int i = 0; i < movies.length; i++) {
                    watched.add(new String(movies[i]));
                }
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return viewers;
    }

    public static void getRegularViewerList () {
        ArrayList<Viewer> viewers = null;
        BufferedReader read = null;
        Viewer viewer = null;
        try{
            read = new BufferedReader(new FileReader("regularViewer.txt"));
            String text = "";
            viewers = new ArrayList<>();
            while ((text = read.readLine())!= null){
                viewer = new Viewer();
                ArrayList<String> watched = new ArrayList<>();
                String arr[] = text.split("\\|");
                viewer.setLogin(arr[0]);
                viewer.setPassword(arr[1]);
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String movies[] = arr[2].split(", ");
                for (int i = 0; i < movies.length; i++) {
                    watched.add(new String(movies[i]));
                }
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < viewers.size(); i++) {
            System.out.println("[" + i + "] " + viewers.get(i).toString());
            System.out.println("________________________________________________________________");
        }
    }

    public static void getVipViewerList () {
        ArrayList<VIPviewer> viewers = null;
        BufferedReader read = null;
        VIPviewer viewer = null;
        try{
            read = new BufferedReader(new FileReader("vipViewer.txt"));
            String text = "";
            viewers = new ArrayList<>();
            while ((text = read.readLine())!= null){
                viewer = new VIPviewer();
                ArrayList<String> watched = new ArrayList<>();
                String arr[] = text.split("\\|");
                viewer.setLogin(arr[0]);
                viewer.setPassword(arr[1]);
                arr[2] =arr[2].toString().replace("[", "").replace("]", "");
                String movies[] = arr[2].split(", ");
                for (int i = 0; i < movies.length; i++) {
                    watched.add(new String(movies[i]));
                }
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < viewers.size(); i++) {
            System.out.println("[" + i + "] " + viewers.get(i).toString());
            System.out.println("________________________________________________________________");
        }
    }*/
}
