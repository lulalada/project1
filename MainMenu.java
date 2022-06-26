package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public MainMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton button1 = new JButton("ENTER AN ACCOUNT");
        button1.setBounds(140, 75, 200, 30);
        add(button1);

        JButton button2 = new JButton("REGISTER");
        button2.setBounds(140, 125, 200, 30);
        add(button2);

        JButton button3 = new JButton("VIEW MOVIES");
        button3.setBounds(140, 175, 200, 30);
        add(button3);

        JButton button4 = new JButton("SEARCH FOR A MOVIE");
        button4.setBounds(140, 225, 200, 30);
        add(button4);

        JButton button5 = new JButton("FILTER MOVIES");
        button5.setBounds(140, 275, 200, 30);
        add(button5);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140, 325, 200, 30);
        add(exitButton);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.login.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.register.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.movieList.setVisible(true);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.search.setVisible(true);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.mainMenu.setVisible(false);
                Main.frame.filter.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
