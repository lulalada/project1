package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipMovieList extends Container {
    public VipMovieList(){
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

        JTextArea area1 = new JTextArea();
        area1.setEditable(false);
        area1.setWrapStyleWord(true);
        area1.setLineWrap(true);
        JScrollPane scroll1 = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll1.setBounds(40, 70, 395, 240);
        add(scroll1);
        scroll1.setVisible(false);

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
                DataBox box1 = new DataBox("VIP movie", "LIST");
                Main.connect(box1);
                String s1 = "";
                for(int i = 0; i < Main.vipMovies.size(); i++){
                    s1+=Main.vipMovies.get(i).getId()  + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                }
                area.setText(s);
                area2.setText(s1);
            }
        });

        JLabel accessLabel = new JLabel("ACCESS:");
        accessLabel.setBounds(75, 345, 70, 30);
        add(accessLabel);

        JTextField accessText = new JTextField();
        accessText.setBounds(165, 345, 40, 30);
        add(accessText);

        JLabel indexLabel = new JLabel("INDEX:");
        indexLabel.setBounds(225, 345, 50, 30);
        add(indexLabel);

        JTextField indexText = new JTextField();
        indexText.setBounds(295, 345, 40, 30);
        add(indexText);

        JButton goButton = new JButton("GO!");

        goButton.setBounds(325, 345, 70, 30);
        add(goButton);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(160, 390, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(true);
                Main.frame.vipMovieList.setVisible(false);
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
                int index = Integer.parseInt(indexText.getText());
                scroll1.setVisible(true);
                scroll.setVisible(false);
                scroll2.setVisible(false);
                if (index >= Main.movies.size()){
                    index = index - Main.movies.size();
                    String s = "MOVIE NAME| " + Main.vipMovies.get(index).getName() + "\n";
                    s+= "YEAR OF PRODUCTION| " + Main.vipMovies.get(index).getYear() + "\n";
                    s+= "GENRES| " + Main.vipMovies.get(index).getGenre() + "\n";
                    s+= "DIRECTOR: | " + Main.vipMovies.get(index).getDirector().getName() + "\n";
                    s+= "ACTORS| " + Main.vipMovies.get(index).getActors() + "\n";
                    s+= "RATING| " + Main.vipMovies.get(index).getRating() + " | number of votes - " + Main.vipMovies.get(index).getRating_count() + "\n";
                    s+= "ANNOTATION/QUICK REVIEW" + "\n";
                    s+= Main.vipMovies.get(index).getReview();
                    area1.setText(s);
                }
                else{
                    String s = "MOVIE NAME| " + Main.movies.get(index).getName() + "\n";
                    s+= "YEAR OF PRODUCTION| " + Main.movies.get(index).getYear() + "\n";
                    s+= "GENRES| " + Main.movies.get(index).getGenre() + "\n";
                    s+= "DIRECTOR: | " + Main.movies.get(index).getDirector().getName() + "\n";
                    s+= "ACTORS| " + Main.movies.get(index).getActors() + "\n";
                    s+= "RATING| " + Main.movies.get(index).getRating() + " | number of votes - " + Main.movies.get(index).getRating_count() + "\n";
                    s+= "ANNOTATION/QUICK REVIEW" + "\n";
                    s+= Main.movies.get(index).getReview();
                    area1.setText(s);
                }
                indexLabel.setVisible(false);
                indexText.setVisible(false);
                goButton.setVisible(false);
                listMovies.setVisible(false);
                backButton.setVisible(false);
                goBack.setVisible(true);
                watch.setVisible(true);
            }
        });

        watch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(indexText.getText());
                int viewerIndex = 0;
                for (int i = 0; i < Main.vipViewers.size(); i++) {
                    if (Main.vipViewers.get(i).getLogin().compareTo(Main.viewer.getLogin()) == 0){
                        viewerIndex = i;
                    }
                }
                if (index >= Main.movies.size()){
                    index = index - Main.movies.size();
                    int count = 0;
                    for (int i = 0; i < Main.viewer.getWatched().size(); i++) {
                        if (Main.vipViewers.get(viewerIndex).getWatched().get(i).compareTo(Main.vipMovies.get(index).getName()) != 0){
                            count++;
                        }
                    }
                    if (count == Main.viewer.getWatched().size()){
                        Main.vipViewers.get(viewerIndex).addMovie(Main.vipMovies.get(index).getName());
                        Main.saveVipAccounts(Main.vipViewers);
                    }
                }
                else{
                    int count = 0;
                    for (int i = 0; i < Main.viewer.getWatched().size(); i++) {
                        if (Main.vipViewers.get(viewerIndex).getWatched().get(i).compareTo(Main.movies.get(index).getName()) != 0){
                            count++;
                        }
                    }
                    if (count == Main.viewer.getWatched().size()){
                        Main.vipViewers.get(viewerIndex).addMovie(Main.movies.get(index).getName());
                        Main.saveVipAccounts(Main.vipViewers);
                    }
                }
                area.setText("");
            }
        });

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scroll1.setVisible(false);
                scroll.setVisible(true);
                scroll2.setVisible(true);
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
