package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class RegularMovieList extends Container {
    public RegularMovieList(){
        setSize(500, 500);
        setLayout(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 50, 450, 240);
        add(scroll);

        JTextArea area1 = new JTextArea();
        area1.setBounds(40, 70, 395, 240);
        area1.setEditable(false);
        area1.setWrapStyleWord(true);
        area1.setLineWrap(true);
        add(area1);
        area1.setVisible(false);

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
            }
        });

        JLabel indexLabel = new JLabel("ENTER INDEX TO WATCH:");
        indexLabel.setBounds(90, 345, 170, 30);
        add(indexLabel);

        JTextField indexText = new JTextField();
        indexText.setBounds(260, 345, 40, 30);
        add(indexText);

        JButton goButton = new JButton("GO!");
        goButton.setBounds(310, 345, 70, 30);
        add(goButton);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(160, 390, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(true);
                Main.frame.regularMovieList.setVisible(false);
                area.setText("");
            }
        });


        JButton goBack = new JButton("GO BACK");
        goBack.setBounds(300, 330, 140, 30);
        add(goBack);
        goBack.setVisible(false);

        JButton watch = new JButton("WATCH");
        watch.setBounds(60, 330, 140, 30);
        add(watch);
        watch.setVisible(false);

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(indexText.getText());
                int index = 0;
                for (int i = 0; i < Main.movies.size(); i++) {
                    if (Main.movies.get(i).getId() == id){
                        index = i;
                    }
                }
                area1.setVisible(true);
                scroll.setVisible(false);
                String s = "MOVIE NAME| " + Main.movies.get(index).getName() + "\n";
                s+= "YEAR OF PRODUCTION| " + Main.movies.get(index).getYear() + "\n";
                s+= "GENRES| " + Main.movies.get(index).getGenre() + "\n";
                s+= "DIRECTOR: | " + Main.movies.get(index).getDirector().getName() + "\n";
                s+= "ACTORS| " + Main.movies.get(index).getActors() + "\n";
                s+= "RATING| " + Main.movies.get(index).getRating() + " | number of votes - " + Main.movies.get(index).getRating_count() + "\n";
                s+= "ANNOTATION/QUICK REVIEW" + "\n";
                s+= Main.movies.get(index).getReview();
                area1.setText(s);
                indexLabel.setVisible(false);
                indexText.setVisible(false);
                goButton.setVisible(false);
                listMovies.setVisible(false);
                backButton.setVisible(false);
                goBack.setVisible(true);
                watch.setVisible(true);
                area.setText("");
            }
        });

        watch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                Long id = Long.parseLong(indexText.getText());
                int index = 0;
                Long viewerIndex = Long.valueOf(0);
                for (int i = 0; i < Main.movies.size(); i++) {
                    if (Objects.equals(Main.movies.get(i).getId(), id)) {
                        index = i;
                    }
                }
                int count = 0;
                /*for (int i = 0; i < Main.viewer.getWatched().size(); i++) {
                    if (Main.viewer.getWatched().get(i).compareTo(Main.movies.get(index).getName()) != 0){
                        count++;
                    }
                }*/
                Viewer viewer1 = new Viewer();
                ArrayList<String> watched = Main.viewer.getWatched();
              //  if (count == Main.viewer.getWatched().size()){
                    watched.add(Main.movies.get(index).getName());
                    System.out.println(watched);
                    viewer1.setId(Main.viewer.getId());
                    viewer1.setLogin(Main.viewer.getLogin());
                    viewer1.setPassword(Main.viewer.getPassword());
                    viewer1.setWatched(watched);
                DataBox box1 = new DataBox("Regular viewer", "UPDATE", viewer1, viewer1.getId());
                Main.connect(box1);
            }
           // }
        });

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area1.setVisible(false);
                scroll.setVisible(true);
                indexLabel.setVisible(true);
                indexText.setVisible(true);
                goButton.setVisible(true);
                listMovies.setVisible(true);
                backButton.setVisible(true);
                goBack.setVisible(false);
                watch.setVisible(false);
                area.setText("");
            }
        });

    }
}
