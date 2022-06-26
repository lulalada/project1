package lab1;

public class WatchedMovie {
    private String name;
    private boolean vote;

    public WatchedMovie() {
    }

    public WatchedMovie(String name, boolean vote) {
        this.name = name;
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public String toStrint(){
        return name + "!" + vote;
    }
}
