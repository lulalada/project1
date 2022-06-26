package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewerMenu extends Container {
    public ViewerMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton listButton = new JButton("VIEW MOVIES");
        listButton.setBounds(150, 50, 200, 30);
        add(listButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.regularMovieList.setVisible(true);
            }
        });

        JButton searchButton = new JButton("SEARCH FOR A MOVIE");
        searchButton.setBounds(150, 100, 200, 30);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.regularSearch.setVisible(true);
            }
        });

        JButton filterButton = new JButton("FILTER MOVIES");
        filterButton.setBounds(150, 150, 200, 30);
        add(filterButton);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.regularFilter.setVisible(true);
            }
        });

        JButton watchedButton = new JButton("WATCHED MOVIES LIST");
        watchedButton.setBounds(150, 200, 200, 30);
        add(watchedButton);

        watchedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.watched.setVisible(true);
            }
        });

        JButton buyButton = new JButton("SUBSCRIPTION PLAN");
        buyButton.setBounds(150, 250, 200, 30);
        add(buyButton);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.subscription.setVisible(true);
            }
        });

        JButton settingsButton = new JButton("SETTINGS");
        settingsButton.setBounds(150, 300, 200, 30);
        add(settingsButton);

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.settings.setVisible(true);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(150, 350, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}
