package lab1;

import java.io.Serializable;
import java.util.ArrayList;

public class VIPviewer implements MovieAccount, Serializable {
    private Long id;
    private String login;
    private String password;
    private ArrayList<String> watched = new ArrayList<>();

    public VIPviewer() {
    }

    public VIPviewer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public VIPviewer(Long id, String login, String password, ArrayList<String> watched) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.watched = watched;
    }

    public VIPviewer(String login, String password, ArrayList<String> watched) {
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

    public void setWatched(ArrayList<String> watched) {
        this.watched = watched;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString(){
        return login + "|" + password + "|" + watched;
    }


}
