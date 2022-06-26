package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Recommendations extends Container {
    public Recommendations(){
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("YOU MAY LIKE!");
        label.setBounds(185, 40, 150, 30);
        add(label);

        JTextArea area = new JTextArea();
        area.setBounds(20, 90, 450, 240);
        area.setEditable(false);
        add(area);

        JButton list = new JButton("LIST");
        list.setBounds(180, 350, 140, 30);
        add(list);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                DataBox box1 = new DataBox("VIP movie", "LIST");
                Main.connect(box1);


                String s = "";
                /*for (int j = 0; j < Main.movies.size(); j++) {
                    Main.allMovie.add(Main.movies.get(j));
                }
                for (int j = 0; j < Main.vipMovies.size(); j++) {
                    Main.allMovie.add(Main.vipMovies.get(j));
                }*/

                int viewerIndex = 0;
                for (int i = 0; i < Main.vipViewers.size(); i++) {
                    if (Main.vipViewers.get(i).getLogin().compareTo(Main.viewer.getLogin()) == 0){
                        viewerIndex = i;
                    }
                }
                ArrayList<Movie> watchedMovie = new ArrayList<>();
                for (int j = 0; j < Main.vipViewers.get(viewerIndex).getWatched().size(); j++){
                    for (int k = 0; k < Main.movies.size(); k++) {
                        if (Main.viewer.getWatched().get(j).compareTo(Main.movies.get(k).getName()) == 0){
                            watchedMovie.add(Main.movies.get(k));
                        }
                    }
                }
                for (int j = 0; j < Main.vipViewers.get(viewerIndex).getWatched().size(); j++){
                    for (int k = 0; k < Main.vipMovies.size(); k++) {
                        if (Main.viewer.getWatched().get(j).compareTo(Main.vipMovies.get(k).getName()) == 0){
                            watchedMovie.add(Main.vipMovies.get(k));
                        }
                    }
                }
                int comedyCount = 0, romanceCount=0, adventureCount = 0, fantasyCount = 0, horrorCount = 0, dramaCount = 0;
                int thrillerCount = 0, actionCount = 0, bioCount = 0, crimeCount = 0;
                int arr[];
                for (int j = 0; j < watchedMovie.size(); j++) {
                    for (int i = 0; i < watchedMovie.get(j).getGenre().size(); i++) {
                        if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Comedy") == 0){
                            comedyCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Romance") == 0){
                            romanceCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Adventure") == 0){
                            adventureCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Fantasy") == 0){
                            fantasyCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Horror") == 0){
                            horrorCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Drama") == 0){
                            dramaCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Thriller") == 0){
                            thrillerCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Action") == 0){
                            actionCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Biography") == 0){
                            bioCount++;
                        }else if (watchedMovie.get(j).getGenre().get(i).getName().compareTo("Crime") == 0){
                            crimeCount++;
                        }
                    }

                }
                if (comedyCount >= romanceCount && comedyCount >= adventureCount && comedyCount >= fantasyCount && comedyCount >= dramaCount &&
                        comedyCount >= thrillerCount && comedyCount >= actionCount && comedyCount >= bioCount && comedyCount >= crimeCount && comedyCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Comedy") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }
                    for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Comedy") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (romanceCount >= comedyCount && romanceCount >= adventureCount && romanceCount >= fantasyCount && romanceCount >= dramaCount &&
                        romanceCount >= thrillerCount && romanceCount >= actionCount && romanceCount >= bioCount && romanceCount >= crimeCount && romanceCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Romance") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }
                    for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Romance") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (adventureCount >= comedyCount && adventureCount >= romanceCount && adventureCount >= fantasyCount && adventureCount >= dramaCount &&
                        adventureCount >= thrillerCount && adventureCount >= actionCount && adventureCount >= bioCount && adventureCount >= crimeCount && adventureCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Adventure") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Adventure") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (fantasyCount >= comedyCount && fantasyCount >= adventureCount && fantasyCount >= romanceCount && fantasyCount >= dramaCount &&
                        fantasyCount >= thrillerCount && fantasyCount >= actionCount && fantasyCount >= bioCount && fantasyCount >= crimeCount && fantasyCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Fantasy") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Fantasy") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (dramaCount >= comedyCount && dramaCount >= adventureCount && dramaCount >= fantasyCount && dramaCount >= romanceCount &&
                        dramaCount >= thrillerCount && dramaCount >= actionCount && dramaCount >= bioCount && dramaCount >= crimeCount && dramaCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Drama") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Drama") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (thrillerCount >= comedyCount && thrillerCount >= adventureCount && thrillerCount >= fantasyCount && thrillerCount >= dramaCount &&
                        thrillerCount >= romanceCount && thrillerCount >= actionCount && thrillerCount >= bioCount && thrillerCount >= crimeCount && thrillerCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Thriller") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Thriller") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (actionCount >= comedyCount && actionCount >= adventureCount && actionCount >= fantasyCount && actionCount >= dramaCount &&
                        actionCount >= romanceCount && actionCount >= thrillerCount && actionCount >= bioCount && actionCount >= crimeCount && actionCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Action") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Action") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (bioCount >= comedyCount && bioCount >= adventureCount && bioCount >= fantasyCount && bioCount >= dramaCount &&
                        bioCount >= romanceCount && bioCount >= actionCount && bioCount >= thrillerCount && bioCount >= crimeCount && bioCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Biography") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Biography") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }else if (crimeCount >= comedyCount && crimeCount >= adventureCount && crimeCount >= fantasyCount && crimeCount >= dramaCount &&
                        crimeCount >= romanceCount && crimeCount >= actionCount && crimeCount >= bioCount && crimeCount >= thrillerCount && crimeCount >= horrorCount){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        for (int k = 0; k < Main.movies.get(j).getGenre().size(); k++) {
                            if (Main.movies.get(j).getGenre().get(k).getName().compareTo("Crime") == 0){
                                s+= Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                            }
                        }
                    }for (int j = 0; j < Main.vipMovies.size(); j++) {
                        for (int k = 0; k < Main.vipMovies.get(j).getGenre().size(); k++) {
                            if (Main.vipMovies.get(j).getGenre().get(k).getName().compareTo("Crime") == 0){
                                s+= Main.vipMovies.get(j).getName() + " " + Main.vipMovies.get(j).getYear() + " " + Main.vipMovies.get(j).getGenre() + " "+ Main.vipMovies.get(j).getRating() +"\n";
                            }
                        }
                    }
                }
                area.setText(s);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(145, 400, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(true);
                Main.frame.recommendations.setVisible(false);
            }
        });
    }
}
