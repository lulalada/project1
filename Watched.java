package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Watched extends Container {
    public Watched(){
        setSize(500, 500);
        setLayout(null);

        JLabel message = new JLabel("WATCHED MOVIES:");
        message.setBounds(170, 50, 150, 30);
        add(message);

        JTextArea area = new JTextArea();
        area.setBounds(20, 100, 450, 180);
        area.setEditable(false);
        add(area);


        JButton rateMovies = new JButton("RATE MOVIE");
        rateMovies.setBounds(145, 310, 200, 30);
        add(rateMovies);

        rateMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.rate.setVisible(true);
                Main.frame.watched.setVisible(false);
            }
        });


        JButton listMovies = new JButton("LIST");
        listMovies.setBounds(145, 360, 200, 30);
        add(listMovies);

        listMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                String s = "";
                for(int i = 0; i < Main.viewer.getWatched().size(); i++){
                    for (int j = 0; j < Main.movies.size(); j++) {
                        if (Main.viewer.getWatched().get(i).compareTo(Main.movies.get(j).getName())== 0){
                            s+=i + ") " + Main.movies.get(j).getName() + " " + Main.movies.get(j).getYear() + " " + Main.movies.get(j).getGenre() + " "+ Main.movies.get(j).getRating() +"\n";
                        }
                    }
                }
                area.setText(s);
            }
        });
        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(145, 410, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(true);
                Main.frame.watched.setVisible(false);
                area.setText("");
            }
        });
    }
}
