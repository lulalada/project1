package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class RegularSearch extends Container {
    public RegularSearch(){
        setSize(500, 500);
        setLayout(null);

        JButton searchButton = new JButton("SEARCH");
        searchButton.setBounds(305, 20, 100, 28);
        add(searchButton);
        JTextField searchText = new JTextField();
        searchText.setBounds(50, 20, 250, 30);
        add(searchText);

        JTextArea area = new JTextArea();
        area.setBounds(20, 70, 450, 240);
        area.setEditable(false);
        add(area);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(175, 330, 150, 30);
        add(backButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
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
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(true);
                Main.frame.regularSearch.setVisible(false);
            }
        });
    }
}
