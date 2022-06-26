package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    public AdminMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton addButton = new JButton("ADD MOVIE");
        addButton.setBounds(140, 100, 200, 30);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(false);
                Main.frame.addMovie.setVisible(true);
            }
        });

        JButton updateButton = new JButton("UPDATE MOVIE");
        updateButton.setBounds(140, 150, 200, 30);
        add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(false);
                Main.frame.updateMovie.setVisible(true);
            }
        });

        JButton deleteButton = new JButton("DELETE MOVIE");
        deleteButton.setBounds(140, 200, 200, 30);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(false);
                Main.frame.deleteMovie.setVisible(true);
            }
        });

        JButton deleteViewer = new JButton("DELETE ACCOUNT");
        deleteViewer.setBounds(140, 250, 200, 30);
        add(deleteViewer);

        deleteViewer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(false);
                Main.frame.deleteAccount.setVisible(true);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(140, 300, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}
