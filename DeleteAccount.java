
package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteAccount extends Container {
    public static String[] accounts = Main.accounts;
    public static String[] vipAccounts = Main.vipAccounts;
    public DeleteAccount(){
        setSize(500, 500);
        setLayout(null);

        JLabel label1 = new JLabel("REGULAR VIEWERS");
        label1.setBounds(180, 20, 200, 30);
        add(label1);

        JComboBox box = new JComboBox(accounts);
        box.setBounds(40, 70, 400, 30);
        add(box);

        JButton delete = new JButton("DELETE");
        delete.setBounds(185, 120, 110, 30);
        add(delete);

        JLabel label2 = new JLabel("VIP VIEWERS");
        label2.setBounds(190, 190, 200, 30);
        add(label2);

        JComboBox box2 = new JComboBox(vipAccounts);
        box2.setBounds(40, 240, 400, 30);
        add(box2);

        JButton delete1 = new JButton("DELETE");
        delete1.setBounds(185, 290, 110, 30);
        add(delete1);

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(140, 350, 200, 30);
        add(backButton);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = (String)box.getSelectedItem();
                Long id = Long.valueOf(0);
                int index = 0;
                for (int i = 0; i < Main.viewers.size(); i++) {
                    if (account.compareTo(Main.viewers.get(i).getLogin()) == 0){
                        id = Main.viewers.get(i).getId();
                        index = i;
                    }
                }
                DataBox dataBox = new DataBox("Regular viewer","DELETE",id);
                Main.connect(dataBox);
                accounts = Main.accounts;
                box.removeItemAt(index+1);
                box.setSelectedItem(accounts[0]);

            }
        });

        delete1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = (String)box2.getSelectedItem();
                Long id = Long.valueOf(0);
                int index = 0;
                for (int i = 0; i < Main.vipViewers.size(); i++) {
                    if (account.compareTo(Main.vipViewers.get(i).getLogin()) == 0){
                        id = Main.vipViewers.get(i).getId();
                        index = i;
                    }
                }
                DataBox dataBox = new DataBox("VIP viewer","DELETE",id);
                Main.connect(dataBox);
                vipAccounts = Main.vipAccounts;
                box2.removeItemAt(index+1);
                box2.setSelectedItem(vipAccounts[0]);

            }

        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deleteAccount.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });
    }
}

