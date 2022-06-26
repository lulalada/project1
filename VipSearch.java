package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class VipSearch extends Container {
    public VipSearch(){
        setSize(500, 500);
        setLayout(null);

        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(305, 20, 100, 28);
        add(searchButton);
        JTextField searchText = new JTextField();
        searchText.setBounds(50, 20, 250, 30);
        add(searchText);

        JLabel label = new JLabel("REGULAR MOVIES:");
        label.setBounds(175, 70, 200, 30);
        add(label);

        JTextArea area = new JTextArea();
        area.setBounds(20, 100, 450, 100);
        area.setEditable(false);
        add(area);

        JLabel label1 = new JLabel("VIP MOVIES:");
        label1.setBounds(190, 220, 200, 30);
        add(label1);

        JTextArea area1 = new JTextArea();
        area1.setBounds(20, 250, 450, 100);
        area1.setEditable(false);
        add(area1);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(175, 370, 150, 30);
        add(backButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                DataBox box1 = new DataBox("VIP movie", "LIST");
                Main.connect(box1);
                String s = "";
                for(int i = 0; i < Main.movies.size(); i++){
                    String arr[] = Main.movies.get(i).getName().split(" ");
                    String arr2[] = searchText.getText().split(" ");
                    if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.movies.get(i).getName().toLowerCase(Locale.ROOT))== 0 || searchText.getText().compareTo(String.valueOf(Main.movies.get(i).getYear()))== 0 ||
                            searchText.getText().compareTo(Main.movies.get(i).getDirector().getName())== 0){
                        s+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                    }
                    else{
                        for (int j = 0; j < arr.length; j++) {
                            for (int k = 0; k < arr2.length; k++) {
                                if (arr[j].toLowerCase(Locale.ROOT).compareTo(arr2[k].toLowerCase(Locale.ROOT)) == 0){
                                    s+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                                }
                            }
                        }
                    }
                    for (int j = 0; j < Main.movies.get(i).getGenre().size(); j++) {
                        if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.movies.get(i).getGenre().get(j).getName().toLowerCase(Locale.ROOT))== 0){
                            s+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                        }
                    }

                    for (int j = 0; j < Main.movies.get(i).getActors().size(); j++) {
                        if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.movies.get(i).getActors().get(j).getName().toLowerCase(Locale.ROOT))== 0){
                            s+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                        }
                    }
                }
                area.setText(s);

                String s1 = "";
                for(int i = 0; i < Main.vipMovies.size(); i++){
                    String arr3[] = Main.vipMovies.get(i).getName().split(" ");
                    String arr4[] = searchText.getText().split(" ");
                    if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.vipMovies.get(i).getName().toLowerCase(Locale.ROOT))== 0 || searchText.getText().compareTo(String.valueOf(Main.vipMovies.get(i).getYear()))== 0 ||
                            searchText.getText().compareTo(Main.vipMovies.get(i).getDirector().getName())== 0){
                        s1+=i + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                    }
                    else{
                        for (int j = 0; j < arr3.length; j++) {
                            for (int k = 0; k < arr4.length; k++) {
                                if (arr3[j].toLowerCase(Locale.ROOT).compareTo(arr4[k].toLowerCase(Locale.ROOT)) == 0){
                                    s1+=i + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                                }
                            }
                        }
                    }
                    for (int j = 0; j < Main.movies.get(i).getGenre().size(); j++) {
                        if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.movies.get(i).getGenre().get(j).getName().toLowerCase(Locale.ROOT))== 0){
                            s1+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                        }
                    }

                    for (int j = 0; j < Main.vipMovies.get(i).getActors().size(); j++) {
                        if (searchText.getText().toLowerCase(Locale.ROOT).compareTo(Main.vipMovies.get(i).getActors().get(j).getName().toLowerCase(Locale.ROOT))== 0){
                            s1+=i + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                        }
                    }
                }
                area1.setText(s1);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(true);
                Main.frame.vipSearch.setVisible(false);
            }
        });
    }
}
