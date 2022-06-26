package lab1;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static ArrayList <Viewer> viewers;
    public static ArrayList<VIPviewer> vipViewers;
    public static ArrayList <RegularMovie> movies;
    public static ArrayList <VIPMovie> vipMovies;
    public static ArrayList<Movie> allMovies;
    public static RegularMovie movie;
    public static VIPMovie vipMovie;
    public static Viewer viewer = new Viewer();
    public static Integer[] years = getYears();
    public static String col[] = getColName();
    public static String data[][];
    public static String accounts[] = getAccounts();
    public static String vipAccounts[] = getVIPAccounts();

    public static void connect(DataBox bigBox){
        try{
            Socket socket = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            if (bigBox.getBoxType().equals("Regular movie")){
                if (bigBox.getOperation().equals("ADD")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("LIST")){
                    outputStream.writeObject(bigBox);
                    MovieBox infoFromServer = (MovieBox) inputStream.readObject();
                    ArrayList<RegularMovie> arrayList = infoFromServer.getMovies();
                    movies = arrayList;
                }else if (bigBox.getOperation().equals("DELETE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("UPDATE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("SELECT")){
                    outputStream.writeObject(bigBox);
                    MovieBox infoFromServer = (MovieBox) inputStream.readObject();
                    RegularMovie movieFromServer = infoFromServer.getMovie();
                    movie = movieFromServer;
                }
            }else if (bigBox.getBoxType().equals("VIP movie")){
                if (bigBox.getOperation().equals("ADD")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("LIST")){
                    outputStream.writeObject(bigBox);
                    VipMovieBox infoFromServer = (VipMovieBox) inputStream.readObject();
                    ArrayList<VIPMovie> arrayList = infoFromServer.getVipMovies();
                    vipMovies = arrayList;
                }else if (bigBox.getOperation().equals("DELETE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("UPDATE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("SELECT")){
                    outputStream.writeObject(bigBox);
                    VipMovieBox infoFromServer = (VipMovieBox) inputStream.readObject();
                    VIPMovie movieFromServer = infoFromServer.getVipMovie();
                    vipMovie = movieFromServer;
                }
            }else if (bigBox.getBoxType().equals("Regular viewer")){
                if (bigBox.getOperation().equals("ADD")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("LIST")){
                    outputStream.writeObject(bigBox);
                    ViewerBox infoFromServer = (ViewerBox) inputStream.readObject();
                    ArrayList<Viewer> arrayList = infoFromServer.getViewers();
                    viewers = arrayList;
                }else if (bigBox.getOperation().equals("DELETE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("UPDATE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("UPDATE SETTINGS")){
                    outputStream.writeObject(bigBox);
                }
            }else if (bigBox.getBoxType().equals("VIP viewer")){
                if (bigBox.getOperation().equals("ADD")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("LIST")){
                    outputStream.writeObject(bigBox);
                    VipViewerBox infoFromServer = (VipViewerBox) inputStream.readObject();
                    ArrayList<VIPviewer> arrayList = infoFromServer.getVipViewers();
                    vipViewers = arrayList;
                }else if (bigBox.getOperation().equals("DELETE")){
                    outputStream.writeObject(bigBox);
                }else if (bigBox.getOperation().equals("UPDATE")){
                    outputStream.writeObject(bigBox);
                }
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void connectMovie(MovieBox box){
        try{
            Socket socket = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if (box.getOperation().equals("ADD")){
                outputStream.writeObject(box);
            }else if (box.getOperation().equals("LIST")){
                outputStream.writeObject(box);
                MovieBox infoFromServer = (MovieBox) inputStream.readObject();
                ArrayList<RegularMovie> arrayList = infoFromServer.getMovies();
                movies = arrayList;
            }
            inputStream.close();
            outputStream.close();
            socket.close();
            }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void connectVipMovie(VipMovieBox box){
        try{
            Socket socket1 = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
            ObjectInputStream inputStream1 = new ObjectInputStream(socket1.getInputStream());

            if (box.getOperation().equals("ADD")){
                outputStream1.writeObject(box);
            }else if (box.getOperation().equals("LIST")){
                outputStream1.writeObject(box);
                VipMovieBox infoFromServer = (VipMovieBox) inputStream1.readObject();
                ArrayList<VIPMovie> arrayList = infoFromServer.getVipMovies();
                vipMovies = arrayList;
            }
            inputStream1.close();
            outputStream1.close();
            socket1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void connectViewer(ViewerBox box){
        try{
            Socket socket = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if (box.getOperation().equals("ADD")){
                outputStream.writeObject(box);
            }else if (box.getOperation().equals("LIST")){
                outputStream.writeObject(box);
                ViewerBox infoFromServer = (ViewerBox) inputStream.readObject();
                ArrayList<Viewer> arrayList = infoFromServer.getViewers();
                viewers = arrayList;
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void connectVipViewer(VipViewerBox box){
        try{
            Socket socket1 = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream1 = new ObjectOutputStream(socket1.getOutputStream());
            ObjectInputStream inputStream1 = new ObjectInputStream(socket1.getInputStream());

            if (box.getOperation().equals("ADD")){
                outputStream1.writeObject(box);
            }else if (box.getOperation().equals("LIST")){
                outputStream1.writeObject(box);
                VipViewerBox infoFromServer = (VipViewerBox) inputStream1.readObject();
                ArrayList<VIPviewer> arrayList = infoFromServer.getVipViewers();
                vipViewers = arrayList;
            }
            inputStream1.close();
            outputStream1.close();
            socket1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        /*DBManager.connect();

        ArrayList <RegularMovie> moviesFromDatabase = DBManager.getRegularMovies();
        for (int i = 0; i < moviesFromDatabase.size(); i++) {
            System.out.println(moviesFromDatabase.get(i));
        }*/

        try{
            Socket socket = new Socket("127.0.0.1", 2510);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());


        }catch (Exception e){
            e.printStackTrace();
        }

        //System.out.println(viewer.getLogin());

    }

    /*public static ArrayList<Movie> getAllMovie(){
        ArrayList<Movie> allMovies = new ArrayList<>();
        for (int j = 0; j < movies.size(); j++) {
            allMovies.add(movies.get(j));
        }
        for (int j = 0; j < vipMovies.size(); j++) {
            allMovies.add(vipMovies.get(j));
        }
        return allMovies;
    }*/

    public static String[] getAccounts(){
        String accounts[] = new String[100];
        DataBox box = new DataBox("Regular viewer", "LIST");
        connect(box);
        accounts[0] = "-";
        for (int i = 0; i < viewers.size(); i++) {
            accounts[i + 1] = viewers.get(i).getLogin();
        }
        return accounts;
    }

    public static String[] getVIPAccounts(){
        String accounts[] = new String[100];
        DataBox box = new DataBox("VIP viewer", "LIST");
        connect(box);
        accounts[0] = "-";
        for (int i = 0; i < vipViewers.size(); i++) {
            accounts[i + 1] = vipViewers.get(i).getLogin();
        }
        return accounts;
    }

    /*public static String[][] getData(){
        String[][] data = new String[Main.movies.size()][4];
        for(int i = 0; i < movies.size(); i++){
            data[i][0] = Main.movies.get(i).getName();
            data[i][1] = String.valueOf(Main.movies.get(i).getYear());
            data[i][2] = String.valueOf(Main.movies.get(i).getGenre());
            data[i][3] = Main.movies.get(i).getCountry();
        }
        return data;
    }*/

    public static String[] getColName(){
        String col[] = {"Name", "Year", "Genre", "Rating"};
        return col;
    }
    public static Integer[] getYears(){
        Integer[] years = new Integer[53];
        for (int i = 0; i <= 52; i++) {
            years[i] = i + 1970;
        }
        return years;
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
    }
}
