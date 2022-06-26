package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Registration extends Container {
    public Registration(){
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

        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(150, 230, 200, 30);
        add(registerButton);

        JLabel message = new JLabel("YOU ARE REGISTERED! PLEASE ENTER ACCOUNT");
        message.setBounds(100, 320, 300, 30);
        add(message);
        message.setVisible(false);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = emailText.getText();
                String password = passwordText.getText();
                Viewer viewer = new Viewer();
                viewer.setId(null);
                viewer.setLogin(login);
                viewer.setPassword(password);
                viewer.setWatched(null);
                DataBox box = new DataBox("Regular viewer", "ADD", viewer);
                Main.connect(box);
                emailText.setText("");
                passwordText.setText("");
                message.setVisible(true);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(150, 280, 200, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.register.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}
