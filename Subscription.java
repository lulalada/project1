package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Subscription extends Container {
    public Subscription(){
        setSize(500, 500);
        setLayout(null);

        JLabel message = new JLabel("YOU DON'T HAVE ANY SUBSCRIPTION PLAN");
        message.setBounds(110, 40, 300, 30);
        add(message);

        String s = "YOU CAN BUY PREMIUM SUBSCRIPTION!" + "\n";
        s+= "You will have an access to watch more videos" + "\n";
        s+= "The latest updates and the best quality" + "\n";
        s+= "A new function of recommendations based on your watched movies" + "\n";
        JTextArea area = new JTextArea();
        area.setBounds(100, 100, 290, 100);
        area.setText(s);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        add(area);

        JButton buy = new JButton("BUY SUBSCRIPTION");
        buy.setBounds(145, 230, 200, 30);
        add(buy);
        JLabel label = new JLabel("CONGRATULATIONS!");
        label.setBounds(182, 340, 150, 30);
        add(label);
        label.setVisible(false);
        JLabel label1 = new JLabel("YOU HAVE SUCCESSFULLY PURCHASED PREMIUM SUBSCRIPTION.");
        label1.setBounds(40, 365, 420, 30);
        add(label1);
        label1.setVisible(false);
        JLabel label2 = new JLabel("PLEASE RE-ENTER TO YOUR ACCOUNT.");
        label2.setBounds(125, 390, 300, 30);
        add(label2);
        label2.setVisible(false);

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VIPviewer vipViewer = new VIPviewer();
                vipViewer.setLogin(Main.viewer.getLogin());
                vipViewer.setPassword(Main.viewer.getPassword());
                vipViewer.setWatched(Main.viewer.getWatched());
                DataBox box = new DataBox("VIP viewer", "ADD", vipViewer);
                Main.connect(box);
                DataBox box1 = new DataBox("Regular viewer", "LIST");
                Main.connect(box1);
                Long viewerId = Long.valueOf(0);
                for (int i = 0; i < Main.viewers.size(); i++) {
                    if (Main.viewers.get(i).getLogin().compareTo(Main.viewer.getLogin()) == 0){
                        viewerId = Main.viewers.get(i).getId();
                    }
                }
                DataBox dataBox = new DataBox("Regular viewer","DELETE",viewerId);
                Main.connect(dataBox);
                label.setVisible(true);
                label1.setVisible(true);
                label2.setVisible(true);
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(175, 290, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.viewerMenu.setVisible(true);
                Main.frame.subscription.setVisible(false);
            }
        });


    }
}
