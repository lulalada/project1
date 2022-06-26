package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Filter extends Container {
    public static String[] genres = {"None", "Drama", "History", "Biography", "Action", "Horror", "Romance", "Comedy"};
    public static Integer[] years = Main.years;
    public static String[] countries = {"None", "USA", "UK", "FR", "KZ"};
    public Filter(){
        setSize(500, 500);
        setLayout(null);

        JLabel genreLabel = new JLabel("GENRE:");
        genreLabel.setBounds(70, 40, 140, 20);
        add(genreLabel);

        JComboBox genreBox = new JComboBox(genres);
        genreBox.setBounds(210, 40, 200, 20);
        add(genreBox);

        JLabel actorLabel = new JLabel("ACTOR:");
        actorLabel.setBounds(70, 70, 140, 20);
        add(actorLabel);

        JTextField actorText = new JTextField("None");
        actorText.setBounds(210, 70, 200, 20);
        add(actorText);

        JLabel yearLabel = new JLabel("MINIMAL YEAR:");
        yearLabel.setBounds(70, 110, 140, 20);
        add(yearLabel);

        JComboBox yearBox = new JComboBox(years);
        yearBox.setBounds(210, 110, 200, 20);
        add(yearBox);

        JLabel countryLabel = new JLabel("COUNTRY:");
        countryLabel.setBounds(70, 150, 140, 20);
        add(countryLabel);

        JComboBox countryBox = new JComboBox(countries);
        countryBox.setBounds(210, 150, 200, 20);
        add(countryBox);

        JLabel ratingLabel = new JLabel("RATING(0-5):");
        ratingLabel.setBounds(70, 190, 140, 20);
        add(ratingLabel);

        JTextField ratingText = new JTextField("0");
        ratingText.setBounds(210, 190, 200, 20);
        add(ratingText);

        JButton findButton = new JButton("FIND");
        findButton.setBounds(175, 220, 150, 30);
        add(findButton);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(50, 260, 380, 140);
        add(scroll);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chosenGenre = (String)genreBox.getSelectedItem();
                String chosenActor = actorText.getText();
                int chosenYear = (int)yearBox.getSelectedItem();
                String chosenCountry = (String)countryBox.getSelectedItem();
                double chosenRating = Double.parseDouble(ratingText.getText());

                Main.movies = Main.getRegularMovies();
                area.setText("");
                String s = "";
                for (int j = 0; j < Main.movies.size(); j++) {
                    area.setText(s);
                    if (chosenGenre.compareTo("None") == 0){
                        if (chosenActor.compareTo("None") == 0){
                            if (Main.movies.get(j).getYear() >= chosenYear){
                                if (Main.movies.get(j).getRating() >= chosenRating){
                                    if (chosenCountry.compareTo("None") == 0){
                                        s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                    }
                                    else if (Main.movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                        s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                    }
                                }
                            }
                        }
                        else{
                            for (int k = 0; k < Main.movies.get(j).getActors().size(); k++) {
                                if (Main.movies.get(j).getActors().get(k).getName().compareTo(chosenActor) == 0) {
                                    if (Main.movies.get(j).getYear() >= chosenYear){
                                        if (Main.movies.get(j).getRating() >= chosenRating){
                                            if (chosenCountry.compareTo("None") == 0){
                                                s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                            }
                                            else if (Main.movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo(chosenGenre) == 0){
                                if (chosenActor.compareTo("None") == 0){
                                    if (Main.movies.get(j).getYear() >= chosenYear){
                                        if (Main.movies.get(j).getRating() >= chosenRating){
                                            if (chosenCountry.compareTo("None") == 0){
                                                s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                            }
                                            else if (Main.movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                            }
                                        }
                                    }
                                }
                                else{
                                    for (int l = 0; l < Main.movies.get(j).getActors().size(); l++) {
                                        if (Main.movies.get(j).getActors().get(l).getName().compareTo(chosenActor) == 0) {
                                            if (Main.movies.get(j).getYear() >= chosenYear){
                                                if (Main.movies.get(j).getRating() >= chosenRating){
                                                    if (chosenCountry.compareTo("None") == 0){
                                                        s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                                                    }
                                                    else if (Main.movies.get(j).getCountry().compareTo(chosenCountry) == 0){
                                                        s+=j + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
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
                area.setText(s);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(175, 410, 150, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.filter.setVisible(false);
            }
        });
    }
}
