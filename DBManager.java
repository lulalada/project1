package lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost/java";
    public static final String user = "postgres";
    public static final String password = "2510";
    public static Connection connection;
    
    public static void connect(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successful database connection");
        }catch (Exception e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
    public static ArrayList<RegularMovie> getRegularMovies(){
        ArrayList<RegularMovie> movies = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.movie");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String director = resultSet.getString("director");
                String review = resultSet.getString("review");
                int rating_count = resultSet.getInt("rating_count");
                String actorString = resultSet.getString("actors");
                String genreString = resultSet.getString("genres");
                String actor[] = actorString.split(", ");
                String genre[] = genreString.split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                RegularMovie movie = new RegularMovie();
                movie.setId(id);
                movie.setName(name);
                movie.setActors(actors);
                movie.setGenres(genres);
                movie.setCountry(country);
                movie.setDirector(new Director(director));
                movie.setRating(rating);
                movie.setReview(review);
                movie.setYear(year);
                movie.setRating_count(rating_count);
                movies.add(movie);
            }
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return movies;
    }
    public static void addRegularMovie(RegularMovie movie){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.movie \n" +
                    "(name, year, genres, country, director, actors, review) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, movie.getName());
            statement.setInt(2, movie.getYear());
            String genre = "";
            for (int i = 0; i < movie.getGenres().size(); i++) {
                genre += movie.getGenres().get(i).getName() + ", ";
            }
            statement.setString(3, genre.substring(0,genre.length() - 2));
            statement.setString(4, movie.getCountry());
            statement.setString(5, movie.getDirector().getName());
            String actor = "";
            for (int i = 0; i < movie.getActors().size(); i++) {
                actor += movie.getActors().get(i).getName() + ", ";
            }
            actor = actor.substring(0,actor.length() - 2);
            statement.setString(6, actor);
            statement.setString(7, movie.getReview());
            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static RegularMovie getRegularMovie(Long id){
        RegularMovie movie = new RegularMovie();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.movie where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                Long movie_id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String director = resultSet.getString("director");
                String review = resultSet.getString("review");
                int rating_count = resultSet.getInt("rating_count");
                String actorString = resultSet.getString("actors");
                String genreString = resultSet.getString("genres");
                String actor[] = actorString.split(", ");
                String genre[] = genreString.split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                movie.setId(movie_id);
                movie.setName(name);
                movie.setActors(actors);
                movie.setGenres(genres);
                movie.setCountry(country);
                movie.setDirector(new Director(director));
                movie.setRating(rating);
                movie.setReview(review);
                movie.setYear(year);
                movie.setRating_count(rating_count);
            }
            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();}
        return movie;
    }
    public static void updateRegularMovie(RegularMovie movie, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.movie SET \n" +
                    "name = ?, year = ?, genres = ?, country = ?, rating = ?, director = ?, actors = ?, review = ?, rating_count = ? \n" +
                    "WHERE id = " + id);

            statement.setString(1, movie.getName());
            statement.setInt(2, movie.getYear());
            String genre = "";
            for (int i = 0; i < movie.getGenres().size(); i++) {
                genre += movie.getGenres().get(i).getName() + ", ";
            }
            statement.setString(3, genre);
            statement.setString(4, movie.getCountry());
            statement.setDouble(5, movie.getRating());
            statement.setString(6, movie.getDirector().getName());
            String actor = "";
            for (int i = 0; i < movie.getActors().size(); i++) {
                actor += movie.getActors().get(i).getName() + ", ";
            }
            statement.setString(7, actor);
            statement.setString(8, movie.getReview());
            statement.setInt(9, movie.getRating_count());

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteRegularMovie(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("delete from public.movie\n" +
                    "where  id = ?");
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static ArrayList<VIPMovie> getVipMovies(){
        ArrayList<VIPMovie> movies = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.vip_movie");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String director = resultSet.getString("director");
                String review = resultSet.getString("review");
                int rating_count = resultSet.getInt("rating_count");
                String actorString = resultSet.getString("actors");
                String genreString = resultSet.getString("genres");
                String actor[] = actorString.split(", ");
                String genre[] = genreString.split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                VIPMovie movie = new VIPMovie();
                movie.setId(id);
                movie.setName(name);
                movie.setActors(actors);
                movie.setGenre(genres);
                movie.setCountry(country);
                movie.setDirector(new Director(director));
                movie.setRating(rating);
                movie.setReview(review);
                movie.setYear(year);
                movie.setRating_count(rating_count);
                movies.add(movie);
            }
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return movies;
    }
    public static void addVipMovie(VIPMovie movie){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.vip_movie \n" +
                    "(name, year, genres, country, director, actors, review) \n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, movie.getName());
            statement.setInt(2, movie.getYear());
            String genre = "";
            for (int i = 0; i < movie.getGenre().size(); i++) {
                genre += movie.getGenre().get(i).getName() + ", ";
            }
            statement.setString(3, genre);
            statement.setString(4, movie.getCountry());
            statement.setString(5, movie.getDirector().getName());
            String actor = "";
            for (int i = 0; i < movie.getActors().size(); i++) {
                actor += movie.getActors().get(i).getName() + ", ";
            }
            actor = actor.substring(0,actor.length() - 2);
            statement.setString(6, actor);
            statement.setString(7, movie.getReview());
            System.out.println(statement);
            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static VIPMovie getVipMovie(Long id){
        VIPMovie movie = new VIPMovie();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.vip_movie where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                Long movie_id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int year = resultSet.getInt("year");
                String country = resultSet.getString("country");
                double rating = resultSet.getDouble("rating");
                String director = resultSet.getString("director");
                String review = resultSet.getString("review");
                int rating_count = resultSet.getInt("rating_count");
                String actorString = resultSet.getString("actors");
                String genreString = resultSet.getString("genres");
                String actor[] = actorString.split(", ");
                String genre[] = genreString.split(", ");

                for (int i = 0; i < actor.length; i++) {
                    actors.add(new Actor(actor[i]));
                }
                for (int i = 0; i < genre.length; i++) {
                    genres.add(new Genre(genre[i]));
                }

                movie.setId(movie_id);
                movie.setName(name);
                movie.setActors(actors);
                movie.setGenre(genres);
                movie.setCountry(country);
                movie.setDirector(new Director(director));
                movie.setRating(rating);
                movie.setReview(review);
                movie.setYear(year);
                movie.setRating_count(rating_count);
            }

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();}
        return movie;
    }
    public static void updateVipMovie(VIPMovie movie, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.vip_movie SET \n" +
                    "name = ?, year = ?, genres = ?, country = ?, rating = ?, director = ?, actors = ?, review = ?, rating_count = ? \n" +
                    "WHERE id = " + id);

            statement.setString(1, movie.getName());
            statement.setInt(2, movie.getYear());
            String genre = "";
            for (int i = 0; i < movie.getGenre().size(); i++) {
                genre += movie.getGenre().get(i).getName() + ", ";
            }
            statement.setString(3, genre);
            statement.setString(4, movie.getCountry());
            statement.setDouble(5, movie.getRating());
            statement.setString(6, movie.getDirector().getName());
            String actor = "";
            for (int i = 0; i < movie.getActors().size(); i++) {
                actor += movie.getActors().get(i).getName() + ", ";
            }
            statement.setString(7, actor);
            statement.setString(8, movie.getReview());
            statement.setInt(9, movie.getRating_count());

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteVipMovie(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("delete from public.vip_movie\n" +
                    "where  id = ?");
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Viewer> getViewers(){
        ArrayList<Viewer> viewers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.viewer");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ArrayList<String> watched = new ArrayList<>();
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String watchedString = resultSet.getString("watched");
                if (watchedString != null){
                    String arr[] = watchedString.split(", ");

                    for (int i = 0; i < arr.length; i++) {
                        watched.add(arr[i]);
                    }
                }
                Viewer viewer = new Viewer();
                viewer.setId(id);
                viewer.setLogin(login);
                viewer.setPassword(password);
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return viewers;
    }
    public static void addViewer(Viewer viewer){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.viewer \n" +
                    "(login, password) \n" +
                    "VALUES (?, ?)");
            statement.setString(1, viewer.getLogin());
            statement.setString(2, viewer.getPassword());

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static Viewer getViewer(Long id){
        Viewer viewer = new Viewer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.viewer where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ArrayList<String> watched = new ArrayList<>();
                Long viewer_id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String watchedString = resultSet.getString("watched");
                String arr[] = watchedString.split(", ");

                for (int i = 0; i < arr.length; i++) {
                    watched.add(arr[i]);
                }
                viewer.setId(viewer_id);
                viewer.setLogin(login);
                viewer.setPassword(password);
                viewer.setWatched(watched);
            }

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();}
        return viewer;
    }
    public static void updateViewer(Viewer viewer, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.viewer SET \n" +
                    "login = ?, password = ?, watched = ? \n" +
                    "WHERE id = " + id);

            statement.setString(1, viewer.getLogin());
            statement.setString(2, viewer.getPassword());
            String watchedString = "";

            for (int i = 0; i < viewer.getWatched().size(); i++) {
                    watchedString += viewer.getWatched().get(i) + ", ";
            }
           watchedString = watchedString.substring(0, watchedString.length() - 2);
            statement.setString(3, watchedString);
            int rows = statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }public static void updateViewerSettings(Viewer viewer, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.viewer SET \n" +
                    "login = ?, password = ? \n" +
                    "WHERE id = " + id);

            statement.setString(1, viewer.getLogin());
            statement.setString(2, viewer.getPassword());

            int rows = statement.executeUpdate();
            statement.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteViewer(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("delete from public.viewer\n" +
                    "where  id = ?");
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<VIPviewer> getVipViewers(){
        ArrayList<VIPviewer> viewers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.vip_viewer");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                ArrayList<String> watched = new ArrayList<>();
                Long id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String watchedString = resultSet.getString("watched");
                if (watchedString != null){
                    String arr[] = watchedString.split(", ");

                    for (int i = 0; i < arr.length; i++) {
                        watched.add(arr[i]);
                    }
                }

                VIPviewer viewer = new VIPviewer();
                viewer.setId(id);
                viewer.setLogin(login);
                viewer.setPassword(password);
                viewer.setWatched(watched);
                viewers.add(viewer);
            }
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return viewers;
    }
    public static void addVipViewer(VIPviewer viewer){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.vip_viewer \n" +
                    "(login, password, watched) \n" +
                    "VALUES (?, ?, ?)");

            statement.setString(1, viewer.getLogin());
            statement.setString(2, viewer.getPassword());
            String watchedString = "";
            for (int i = 0; i < viewer.getWatched().size(); i++) {
                watchedString += viewer.getWatched().get(i) + ", ";
            }
            watchedString = watchedString.substring(0,watchedString.length() - 2);
            statement.setString(3, watchedString);
            //actor = actor.substring(0,actor.length() - 2);

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static VIPviewer getVipViewer(Long id){
        VIPviewer viewer = new VIPviewer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.vip_viewer where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                ArrayList<String> watched = new ArrayList<>();
                Long viewer_id = resultSet.getLong("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String watchedString = resultSet.getString("watched");
                String arr[] = watchedString.split(", ");

                for (int i = 0; i < arr.length; i++) {
                    watched.add(arr[i]);
                }
                viewer.setId(viewer_id);
                viewer.setLogin(login);
                viewer.setPassword(password);
                viewer.setWatched(watched);
            }

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();}
        return viewer;
    }
    public static void updateVipViewer(VIPviewer viewer, Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.vip_viewer SET \n" +
                    "login = ?, password = ? \n" +
                    "WHERE id = " + id);

            statement.setString(1, viewer.getLogin());
            statement.setString(2, viewer.getPassword());

            int rows = statement.executeUpdate();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteVipViewer(Long id){
        try {
            PreparedStatement statement = connection.prepareStatement("delete from public.vip_viewer\n" +
                    "where  id = ?");
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
