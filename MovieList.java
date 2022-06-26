package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class MovieList extends Container {


    public MovieList(){
        setSize(500, 500);
        //setLayout(null);


        /*JTable table = new JTable(Main.data,Main.col);
        table.setLocation(1, 1);
        table.setBounds(20,50,450,240);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVisible(true);
        add(scroll);*/

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 50, 450, 240);
        add(scroll);



        JButton listMovies = new JButton("LIST");
        listMovies.setBounds(160, 300, 140, 30);
        add(listMovies);


        listMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*MovieBox box = new MovieBox("LIST");
                Main.connectMovie(box);
                String s = "";
                for(int i = 0; i < Main.movies.size(); i++){
                    s+=i + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                }*/
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                String s = "";
                for(int i = 0; i < Main.movies.size(); i++){
                    s+=Main.movies.get(i).getId() + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                }
                area.setText(s);
            }
        });


        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(160, 340, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(true);
                Main.frame.movieList.setVisible(false);
                area.setText("");
            }
        });
    }

}
