package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VIPmenu extends Container {
    public VIPmenu(){
        setSize(500, 500);
        setLayout(null);

        JButton listButton = new JButton("VIEW MOVIES");
        listButton.setBounds(150, 40, 200, 30);
        add(listButton);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipMovieList.setVisible(true);
            }
        });

        JButton searchButton = new JButton("SEARCH FOR A MOVIE");
        searchButton.setBounds(150, 90, 200, 30);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipSearch.setVisible(true);
            }
        });

        JButton filterButton = new JButton("FILTER MOVIES");
        filterButton.setBounds(150, 140, 200, 30);
        add(filterButton);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipFilter.setVisible(true);
            }
        });

        JButton watchedButton = new JButton("WATCHED MOVIES LIST");
        watchedButton.setBounds(150, 190, 200, 30);
        add(watchedButton);

        watchedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipWatched.setVisible(true);
            }
        });

        JButton buyButton = new JButton("SUBSCRIPTION PLAN");
        buyButton.setBounds(150, 240, 200, 30);
        add(buyButton);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipSubscription.setVisible(true);
            }
        });

        JButton settingsButton = new JButton("SETTINGS");
        settingsButton.setBounds(150, 290, 200, 30);
        add(settingsButton);

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipSettings.setVisible(true);
            }
        });

        JButton recommendation = new JButton("RECOMMENDATIONS");
        recommendation.setBounds(150, 340, 200, 30);
        add(recommendation);

        recommendation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.recommendations.setVisible(true);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(150, 390, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}

