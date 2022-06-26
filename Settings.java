package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends Container {
    public Settings() {
        setSize(500, 500);
        setLayout(null);

        JLabel emailLabel = new JLabel("E-MAIL:");
        emailLabel.setBounds(100, 50, 75, 30);
        add(emailLabel);


        JTextField emailText = new JTextField();
        emailText.setBounds(200, 50, 150, 30);
        emailText.setEditable(false);
        String login = Main.viewer.getLogin();
        add(emailText);
        emailText.setText(login);


        JLabel newEmailLabel = new JLabel("NEW E-MAIl:");
        newEmailLabel.setBounds(100, 100, 100, 30);
        newEmailLabel.setVisible(false);
        add(newEmailLabel);
        JTextField newEmailText = new JTextField(Main.viewer.getLogin());
        newEmailText.setBounds(200, 100, 150, 30);
        newEmailText.setVisible(false);
        add(newEmailText);


        JButton emailChange = new JButton("change e-mail");
        emailChange.setBounds(170, 100, 150, 30);
        add(emailChange);


        emailChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emailChange.setVisible(false);
                newEmailLabel.setVisible(true);
                newEmailText.setVisible(true);
            }
        });

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 150, 100, 30);
        add(passwordLabel);
        JTextField passwordText = new JTextField("****");
        passwordText.setBounds(200, 150, 150, 30);
        passwordText.setEditable(false);
        add(passwordText);
        JButton passwordChange = new JButton("change password");
        passwordChange.setBounds(170, 200, 150, 30);
        add(passwordChange);

        JLabel oldPasswordLabel = new JLabel("OLD PASSWORD:");
        oldPasswordLabel.setBounds(95, 150, 110, 30);
        oldPasswordLabel.setVisible(false);
        add(oldPasswordLabel);
        JTextField oldPasswordText = new JTextField();
        oldPasswordText.setBounds(210, 150, 150, 30);
        oldPasswordText.setVisible(false);
        add(oldPasswordText);

        JLabel newPasswordLabel = new JLabel("NEW PASSWORD:");
        newPasswordLabel.setBounds(95, 200, 110, 30);
        newPasswordLabel.setVisible(false);
        add(newPasswordLabel);
        JTextField newPasswordText = new JTextField();
        newPasswordText.setBounds(210, 200, 150, 30);
        newPasswordText.setVisible(false);
        add(newPasswordText);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(170, 300, 150, 30);
        add(saveButton);

        passwordChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordLabel.setVisible(false);
                passwordText.setVisible(false);
                passwordChange.setVisible(false);
                newPasswordText.setVisible(true);
                newPasswordLabel.setVisible(true);
                oldPasswordText.setVisible(true);
                oldPasswordLabel.setVisible(true);
                saveButton.setVisible(true);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = newEmailText.getText();
                String oldPassword = oldPasswordText.getText();
                String newPassword = newPasswordText.getText();
                if (email != null){
                    Main.viewer.setLogin(email);
                }
                if (newPassword != null){
                    if (oldPassword.compareTo(Main.viewer.getPassword()) == 0){
                        Main.viewer.setPassword(newPassword);
                    }
                }
                DataBox box1 = new DataBox("Regular viewer", "UPDATE SETTINGS", Main.viewer, Main.viewer.getId());
                Main.connect(box1);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(170, 350, 150, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(true);
                Main.frame.settings.setVisible(false);
            }
        });
    }
}
