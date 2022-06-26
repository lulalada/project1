package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipSubscription extends Container {
    public VipSubscription(){
        setSize(500, 500);
        setLayout(null);

        JLabel message = new JLabel("YOU ARE ON PREMIUM SUBSCRIPTION PLAN");
        message.setBounds(110, 40, 300, 30);
        add(message);

        String s = "YOUR SUBSCRIPTION PLAN CONSISTS OF THESE SERVICES" + "\n";
        s+= "You have an access to watch more videos" + "\n";
        s+= "The latest updates and the best quality" + "\n";
        s+= "A new function of recommendations based on your watched movies" + "\n";
        JTextArea area = new JTextArea();
        area.setBounds(100, 100, 290, 100);
        area.setText(s);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        add(area);

        JButton cancel = new JButton("CANCEL SUBSCRIPTION");
        cancel.setBounds(145, 230, 200, 30);
        add(cancel);
        JLabel label1 = new JLabel("YOU HAVE CANCELLED SUBSCRIPTION");
        label1.setBounds(125, 365, 420, 30);
        add(label1);
        label1.setVisible(false);
        JLabel label2 = new JLabel("PLEASE RE-ENTER TO YOUR ACCOUNT.");
        label2.setBounds(125, 390, 300, 30);
        add(label2);
        label2.setVisible(false);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Viewer regularViewer = new Viewer();
                regularViewer.setLogin(Main.viewer.getLogin());
                regularViewer.setPassword(Main.viewer.getPassword());
                regularViewer.setWatched(Main.viewer.getWatched());

                DataBox box = new DataBox("Regular viewer", "ADD", regularViewer);
                Main.connect(box);
                DataBox box1 = new DataBox("VIP viewer", "LIST");
                Main.connect(box1);
                Long viewerId = Long.valueOf(0);
                for (int i = 0; i < Main.viewers.size(); i++) {
                    if (Main.viewers.get(i).getLogin().compareTo(Main.viewer.getLogin()) == 0){
                        viewerId = Main.viewers.get(i).getId();
                    }
                }
                DataBox dataBox = new DataBox("VIP viewer","DELETE",viewerId);
                Main.connect(dataBox);
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
                Main.frame.vipMenu.setVisible(true);
                Main.frame.vipSubscription.setVisible(false);
            }
        });
    }
}
