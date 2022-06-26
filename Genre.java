package lab1;

import java.io.Serializable;

public class Genre implements Serializable {
    public String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String genre) {
        this.name = genre;
    }

    public String toString(){
        return name;
    }
}
