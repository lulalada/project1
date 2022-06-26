package lab1;

import songplaylist.Song;

import java.io.Serializable;
import java.util.ArrayList;

public class Viewer implements MovieAccount, Serializable {
    private Long id;
    private String login;
    private String password;
    private ArrayList<String> watched = new ArrayList<>();

    public Viewer() {
    }
    public Viewer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Viewer(Long id, String login, String password, ArrayList<String> watched) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.watched = watched;
    }

    public Viewer(String login, String password, ArrayList<String> watched) {
        this.login = login;
        this.password = password;
        this.watched = watched;
    }

    public void addMovie(String movie){
        for (int i = 0; i < watched.size(); i++) {
            if ("null".compareTo(watched.get(i)) == 0){
                watched.remove(i);
            }
        }
        watched.add(movie);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getWatched() {
        return watched;
    }

    public void setWatched(ArrayList<String> watched) {
        this.watched = watched;
    }

    public String toString(){
        return login + "|" + password + "|" + watched;
    }
}
