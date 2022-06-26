package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateMovie extends Container {
    public String[] levels = {"Regular", "VIP"};
    public String[] levels1 = {"VIP","Regular"};
    public UpdateMovie(){
        setSize(500, 500);
        setLayout(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 20, 450, 125);
        add(scroll);

        JTextArea area2 = new JTextArea();
        area2.setEditable(false);
        JScrollPane scroll2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setBounds(20, 165, 450, 125);
        add(scroll2);

        JButton listMovies = new JButton("LIST");
        listMovies.setBounds(160, 300, 140, 30);
        add(listMovies);


        listMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                String s = "";
                for(int i = 0; i < Main.movies.size(); i++){
                    s+=Main.movies.get(i).getId() + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                }
                area.setText(s);
                DataBox box1 = new DataBox("VIP movie", "LIST");
                Main.connect(box1);
                String s1 = "";
                for(int i = 0; i < Main.vipMovies.size(); i++){
                    s1+=Main.vipMovies.get(i).getId() + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                }
                area2.setText(s1);
            }
        });

        JLabel accessLabel = new JLabel("ACCESS:");
        accessLabel.setBounds(40, 345, 70, 30);
        add(accessLabel);

        JComboBox accessBox = new JComboBox(levels);
        accessBox.setBounds(115, 350, 100, 20);
        add(accessBox);


        JLabel indexLabel = new JLabel("INDEX:");
        indexLabel.setBounds(235, 345, 50, 30);
        add(indexLabel);

        JTextField indexText = new JTextField();
        indexText.setBounds(300, 345, 40, 30);
        add(indexText);

        JButton update = new JButton("UPDATE");
        update.setBounds(360, 345, 100, 30);
        add(update);


        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(160, 390, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(true);
                Main.frame.updateMovie.setVisible(false);
                area.setText("");
            }
        });

        JLabel nameLabel = new JLabel("MOVIE NAME:");
        nameLabel.setBounds(70, 40, 140, 20);
        add(nameLabel);
        nameLabel.setVisible(false);

        JTextField nameText = new JTextField();
        nameText.setBounds(210, 40, 200, 20);
        add(nameText);
        nameText.setVisible(false);

        JLabel yearLabel = new JLabel("PRODUCTION YEAR:");
        yearLabel.setBounds(70, 80, 140, 20);
        add(yearLabel);
        yearLabel.setVisible(false);

        JTextField yearText = new JTextField();
        yearText.setBounds(210, 80, 200, 20);
        add(yearText);
        yearText.setVisible(false);

        JLabel genreLabel = new JLabel("GENRE(S):");
        genreLabel.setBounds(70, 120, 140, 20);
        add(genreLabel);
        genreLabel.setVisible(false);

        JTextField genreText = new JTextField();
        genreText.setBounds(210, 120, 200, 20);
        add(genreText);
        genreText.setVisible(false);

        JLabel countryLabel = new JLabel("COUNTRY:");
        countryLabel.setBounds(70, 160, 140, 20);
        add(countryLabel);
        countryLabel.setVisible(false);

        JTextField countryText = new JTextField();
        countryText.setBounds(210, 160, 200, 20);
        add(countryText);
        countryText.setVisible(false);

        JLabel directorLabel = new JLabel("DIRECTOR:");
        directorLabel.setBounds(70, 200, 140, 20);
        add(directorLabel);
        directorLabel.setVisible(false);

        JTextField directorText = new JTextField();
        directorText.setBounds(210, 200, 200, 20);
        add(directorText);
        directorText.setVisible(false);

        JLabel actorLabel = new JLabel("ACTOR(S):");
        actorLabel.setBounds(70, 240, 140, 20);
        add(actorLabel);
        actorLabel.setVisible(false);

        JTextField actorText = new JTextField();
        actorText.setBounds(210, 240, 200, 20);
        add(actorText);
        actorText.setVisible(false);

        JLabel reviewLabel = new JLabel("REVIEW:");
        reviewLabel.setBounds(70, 280, 140, 20);
        add(reviewLabel);
        reviewLabel.setVisible(false);

        JTextField reviewText = new JTextField();
        reviewText.setBounds(210, 280, 200, 20);
        add(reviewText);
        reviewText.setVisible(false);


        JButton updateMovie = new JButton("UPDATE MOVIE");
        updateMovie.setBounds(150, 360, 150, 30);
        add(updateMovie);
        updateMovie.setVisible(false);

        JButton goBack = new JButton("GO BACK");
        goBack.setBounds(150, 410, 150, 30);
        add(goBack);
        goBack.setVisible(false);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long index = Long.parseLong(indexText.getText());
                String access = (String)accessBox.getSelectedItem();

                area.setText("");
                area2.setText("");
                scroll.setVisible(false);
                scroll2.setVisible(false);
                indexText.setVisible(false);
                listMovies.setVisible(false);
                backButton.setVisible(false);
                accessLabel.setVisible(false);
                accessBox.setVisible(false);
                update.setVisible(false);
                indexLabel.setVisible(false);
                indexText.setVisible(false);

                directorLabel.setVisible(true);
                genreLabel.setVisible(true);
                nameLabel.setVisible(true);
                nameText.setVisible(true);
                yearLabel.setVisible(true);
                yearText.setVisible(true);
                genreText.setVisible(true);
                countryLabel.setVisible(true);
                countryText.setVisible(true);
                directorText.setVisible(true);
                actorLabel.setVisible(true);
                actorText.setVisible(true);
                reviewLabel.setVisible(true);
                reviewText.setVisible(true);

                updateMovie.setVisible(true);
                goBack.setVisible(true);

                if (access.compareTo("Regular") == 0){
                    DataBox box = new DataBox("Regular movie","SELECT",index);
                    Main.connect(box);
                    nameText.setText(Main.movie.getName());
                    yearText.setText(String.valueOf(Main.movie.getYear()));
                    String genres = "";
                    for (int i = 0; i < Main.movie.getGenre().size(); i++) {
                        genres += Main.movie.getGenre().get(i).getName() + ",";
                    }
                    genreText.setText(genres);
                    countryText.setText(Main.movie.getCountry());
                    directorText.setText(Main.movie.getDirector().getName());
                    String actors = "";
                    for (int i = 0; i < Main.movie.getActors().size(); i++) {
                        actors += Main.movie.getActors().get(i).getName() + ",";
                    }
                    actorText.setText(actors);
                    reviewText.setText(Main.movie.getReview());
                }else if (access.compareTo("VIP") == 0){
                    DataBox box = new DataBox("VIP movie", "SELECT", index);
                    Main.connect(box);

                    nameText.setText(Main.vipMovie.getName());
                    yearText.setText(String.valueOf(Main.vipMovie.getYear()));
                    String genres = "";
                    for (int i = 0; i < Main.vipMovie.getGenre().size(); i++) {
                        genres += Main.vipMovie.getGenre().get(i).getName();
                        genres +=",";
                    }
                    genreText.setText(genres);
                    countryText.setText(Main.vipMovie.getCountry());
                    directorText.setText(Main.vipMovie.getDirector().getName());
                    String actors = "";
                    for (int i = 0; i < Main.vipMovie.getActors().size(); i++) {
                        actors += Main.vipMovie.getActors().get(i).getName();
                        actors += ",";
                    }
                    actorText.setText(actors);
                    reviewText.setText(Main.vipMovie.getReview());
                }
            }
        });
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scroll.setVisible(true);
                scroll2.setVisible(true);
                indexText.setVisible(true);
                listMovies.setVisible(true);
                backButton.setVisible(true);
                accessLabel.setVisible(true);
                accessBox.setVisible(true);
                update.setVisible(true);
                indexLabel.setVisible(true);
                indexText.setVisible(true);

                directorLabel.setVisible(false);
                genreLabel.setVisible(false);
                nameLabel.setVisible(false);
                nameText.setVisible(false);
                yearLabel.setVisible(false);
                yearText.setVisible(false);
                genreText.setVisible(false);
                countryLabel.setVisible(false);
                countryText.setVisible(false);
                directorText.setVisible(false);
                actorLabel.setVisible(false);
                actorText.setVisible(false);
                reviewLabel.setVisible(false);
                reviewText.setVisible(false);

                updateMovie.setVisible(false);
                goBack.setVisible(false);
            }
        });

        updateMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long index = Long.parseLong(indexText.getText());
                area.setText("");
                area2.setText("");
                indexText.setText("");
                String name = nameText.getText();
                int year = Integer.parseInt(yearText.getText());
                String director = directorText.getText();
                String country = countryText.getText();
                String review = reviewText.getText();
                String actorArray[] = actorText.getText().split(",");
                String genreArray[] = genreText.getText().split(",");
                ArrayList<Actor> actors = new ArrayList<>();
                ArrayList<Genre> genres = new ArrayList<>();
                String level = (String)accessBox.getSelectedItem();
                if (level.compareTo("Regular") == 0) {

                    for (int j = 0; j < actorArray.length; j++) {
                        actors.add(new Actor(actorArray[j]));
                    }
                    for (int j = 0; j < genreArray.length; j++) {
                        genres.add(new Genre(genreArray[j]));
                    }

                    Main.movie.setId(index);
                    Main.movie.setName(name);
                    Main.movie.setActors(actors);
                    Main.movie.setGenre(genres);
                    Main.movie.setCountry(country);
                    Main.movie.setDirector(new Director(director));
                    Main.movie.setReview(review);
                    Main.movie.setYear(year);
                    DataBox box = new DataBox("Regular movie", "UPDATE", Main.movie, Main.movie.getId());
                    Main.connect(box);
                    // Main.saveRegularMovie(movie);
                }

                else if (level.compareTo("VIP") == 0) {
                    for (int j = 0; j < actorArray.length; j++) {
                        actors.add(new Actor(actorArray[j]));
                    }
                    for (int j = 0; j < genreArray.length; j++) {
                        genres.add(new Genre(genreArray[j]));
                    }
                    Main.vipMovie.setName(name);
                    Main.vipMovie.setActors(actors);
                    Main.vipMovie.setGenre(genres);
                    Main.vipMovie.setCountry(country);
                    Main.vipMovie.setDirector(new Director(director));
                    Main.vipMovie.setReview(review);
                    Main.vipMovie.setYear(year);
                    DataBox box1 = new DataBox("VIP movie", "UPDATE", Main.vipMovie, Main.vipMovie.getId());
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
                indexText.setText("");
            }
        });
    }
}
