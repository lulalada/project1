package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rate extends Container {
    public Rate(){
        setSize(500, 500);
        setLayout(null);

        JLabel message = new JLabel("MOVIES YOU CAN RATE:");
        message.setBounds(180, 40, 150, 30);
        add(message);

        JTextArea area = new JTextArea();
        area.setBounds(145, 90, 200, 180);
        area.setEditable(false);
        add(area);


        JLabel index = new JLabel("INDEX:");
        index.setBounds(80, 290,50, 30);
        add(index);
        JTextField indexText = new JTextField();
        indexText.setBounds(130, 290, 50, 30);
        add(indexText);
        JLabel rating = new JLabel("RATING:");
        rating.setBounds(200, 290, 55, 30);
        add(rating);
        JTextField ratingText = new JTextField();
        ratingText.setBounds(255, 290, 50, 30);
        add(ratingText);
        JButton rate = new JButton("RATE");
        rate.setBounds(325, 290, 80, 30);
        add(rate);

        rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Integer.parseInt(indexText.getText());
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);

                double rating = Double.parseDouble(ratingText.getText());
                for (int i = 0; i < Main.movies.size(); i++) {
                    if (Main.viewer.getWatched().get(index-1).compareTo(Main.movies.get(i).getName()) == 0){
                        System.out.println(Main.movies.get(i).getName());
                        int rating_count = Main.movies.get(i).getRating_count();
                        double wholeRating = Main.movies.get(i).getRating();
                        wholeRating = wholeRating * rating_count;
                        rating_count++;
                        wholeRating = (wholeRating + rating)/rating_count;
                        Main.movies.get(i).setRating(wholeRating);
                        Main.movies.get(i).setRating_count(rating_count);
                        DataBox box1 = new DataBox("Regular movie", "UPDATE", Main.movies.get(i), Main.movies.get(i).getId());
                        Main.connect(box1);
                    }
                }
                indexText.setText("");
                ratingText.setText("");
            }
        });

        JButton listMovies = new JButton("LIST");
        listMovies.setBounds(145, 360, 200, 30);
        add(listMovies);

        listMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = "";
                for(int i = 0; i < Main.viewer.getWatched().size(); i++){
                    s+=(i+1) + ") " + Main.viewer.getWatched().get(i) +"\n";

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
                Main.frame.watched.setVisible(true);
                Main.frame.rate.setVisible(false);
                area.setText("");
            }
        });
    }

}
