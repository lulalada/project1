package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Login extends Container {
    public Login(){
        setSize(500, 500);
        setLayout(null);

        JLabel emailLabel = new JLabel("EMAIL:");
        emailLabel.setBounds(140, 120, 75, 30);
        add(emailLabel);
        JTextField emailText = new JTextField();
        emailText.setBounds(230, 120, 135, 30);
        add(emailText);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(140, 170, 75, 30);
        add(passwordLabel);
        JTextField passwordText = new JTextField();
        passwordText.setBounds(230, 170, 135, 30);
        add(passwordText);

        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(150, 230, 200, 30);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = emailText.getText();
                String password = passwordText.getText();
                Admin admin1 = new Admin("alua@gmail.com", "alua");
                Admin admin2 = new Admin("dina@gmail.com", "dina");
                ArrayList<Admin> admins = new ArrayList<>();
                admins.add(admin1);
                admins.add(admin2);
                for (int i = 0; i < admins.size(); i++) {
                    if (admins.get(i).getLogin().compareTo(login) == 0 && admins.get(i).getPassword().compareTo(password)== 0){
                        Main.frame.login.setVisible(false);
                        Main.frame.adminMenu.setVisible(true);
                    }
                }
                DataBox box = new DataBox("Regular viewer", "LIST");
                Main.connect(box);
                for (int i = 0; i < Main.viewers.size(); i++) {
                    if (Main.viewers.get(i).getLogin().compareTo(login) == 0 && Main.viewers.get(i).getPassword().compareTo(password)== 0){
                        Main.viewer.setId(Main.viewers.get(i).getId());
                        Main.viewer.setLogin(login);
                        Main.viewer.setPassword(password);
                        Main.viewer.setWatched(Main.viewers.get(i).getWatched());
                        System.out.println(Main.viewer.getLogin());

                        Main.frame.login.setVisible(false);
                        Main.frame.viewerMenu.setVisible(true);
                    }
                }
                DataBox box1 = new DataBox("VIP viewer", "LIST");
                Main.connect(box1);
                for (int i = 0; i < Main.vipViewers.size(); i++) {
                    if (Main.vipViewers.get(i).getLogin().compareTo(login) == 0 && Main.vipViewers.get(i).getPassword().compareTo(password)== 0){
                        Main.viewer.setId(Main.vipViewers.get(i).getId());
                        Main.viewer.setLogin(login);
                        Main.viewer.setPassword(password);
                        Main.viewer.setWatched(Main.vipViewers.get(i).getWatched());

                        Main.frame.login.setVisible(false);
                        Main.frame.vipMenu.setVisible(true);
                    }
                }
                emailText.setText("");
                passwordText.setText("");
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(150, 280, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.login.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }

}
