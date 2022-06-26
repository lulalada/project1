package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMovie extends Container {
    public String[] levels = {"Regular", "VIP"};
    public AddMovie(){
        setSize(500, 500);
        setLayout(null);

        JLabel nameLabel = new JLabel("MOVIE NAME:");
        nameLabel.setBounds(70, 40, 140, 20);
        add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setBounds(210, 40, 200, 20);
        add(nameText);

        JLabel yearLabel = new JLabel("PRODUCTION YEAR:");
        yearLabel.setBounds(70, 80, 140, 20);
        add(yearLabel);

        JTextField yearText = new JTextField();
        yearText.setBounds(210, 80, 200, 20);
        add(yearText);

        JLabel genreLabel = new JLabel("GENRE(S):");
        genreLabel.setBounds(70, 120, 140, 20);
        add(genreLabel);

        JTextField genreText = new JTextField();
        genreText.setBounds(210, 120, 200, 20);
        add(genreText);

        JLabel countryLabel = new JLabel("COUNTRY:");
        countryLabel.setBounds(70, 160, 140, 20);
        add(countryLabel);

        JTextField countryText = new JTextField();
        countryText.setBounds(210, 160, 200, 20);
        add(countryText);

        JLabel directorLabel = new JLabel("DIRECTOR:");
        directorLabel.setBounds(70, 200, 140, 20);
        add(directorLabel);

        JTextField directorText = new JTextField();
        directorText.setBounds(210, 200, 200, 20);
        add(directorText);

        JLabel actorLabel = new JLabel("ACTOR(S):");
        actorLabel.setBounds(70, 240, 140, 20);
        add(actorLabel);

        JTextField actorText = new JTextField();
        actorText.setBounds(210, 240, 200, 20);
        add(actorText);

        JLabel reviewLabel = new JLabel("REVIEW:");
        reviewLabel.setBounds(70, 280, 140, 20);
        add(reviewLabel);

        JTextField reviewText = new JTextField();
        reviewText.setBounds(210, 280, 200, 20);
        add(reviewText);

        JLabel levelLabel = new JLabel("LEVEL OF ACCESS:");
        levelLabel.setBounds(70, 320, 140, 20);
        add(levelLabel);

        JComboBox levelBox = new JComboBox(levels);
        levelBox.setBounds(210, 320, 200, 20);
        add(levelBox);

        JButton addMovie = new JButton("ADD MOVIE");
        addMovie.setBounds(150, 360, 150, 30);
        add(addMovie);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(150, 400, 150, 30);
        add(backButton);

        addMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                int year = Integer.parseInt(yearText.getText());
                String director = directorText.getText();
                String country = countryText.getText();
                String review = reviewText.getText();
                String actorArray[] = actorText.getText().split(",");
                String genreArray[] = genreText.getText().split(",");
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String level = (String)levelBox.getSelectedItem();
                if (level.compareTo("Regular") == 0) {
                    RegularMovie movie = new RegularMovie();
                    for (int j = 0; j < actorArray.length; j++) {
                        actors.add(new Actor(actorArray[j]));
                    }
                    for (int j = 0; j < genreArray.length; j++) {
                        genres.add(new Genre(genreArray[j]));
                    }
                    movie = new RegularMovie();
                    movie.setId(null);
                    movie.setName(name);
                    movie.setActors(actors);
                    movie.setGenre(genres);
                    movie.setCountry(country);
                    movie.setDirector(new Director(director));
                    movie.setRating(0);
                    movie.setReview(review);
                    movie.setYear(year);
                    DataBox box = new DataBox("Regular movie", "ADD", movie);
                    Main.connect(box);
                    // Main.saveRegularMovie(movie);
                }

                else if (level.compareTo("VIP") == 0) {
                    VIPMovie vipMovie = new VIPMovie();
                    for (int j = 0; j < actorArray.length; j++) {
                        actors.add(new Actor(actorArray[j]));
                    }
                    for (int j = 0; j < genreArray.length; j++) {
                        genres.add(new Genre(genreArray[j]));
                    }
                    vipMovie = new VIPMovie();
                    vipMovie.setId(null);
                    vipMovie.setName(name);
                    vipMovie.setActors(actors);
                    vipMovie.setGenre(genres);
                    vipMovie.setCountry(country);
                    vipMovie.setDirector(new Director(director));
                    vipMovie.setRating(0);
                    vipMovie.setReview(review);
                    vipMovie.setYear(year);
                    DataBox box1 = new DataBox("VIP movie", "ADD", vipMovie);
                    Main.connect(box1);
                    //Main.saveVipMovie(vipMovie);
                }
                nameText.setText("");
                yearText.setText("");
                genreText.setText("");
                actorText.setText("");
                countryText.setText("");
                reviewText.setText("");
                directorText.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addMovie.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });
    }
}
