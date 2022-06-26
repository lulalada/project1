package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMovie extends Container {
    public String[] levels = {"Regular", "VIP"};
    public DeleteMovie(){
        setSize(500, 500);
        setLayout(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(20, 20, 450, 125);
        add(scroll);

        JTextArea area2 = new JTextArea();
        area2.setEditable(false);
        JScrollPane scroll2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setBounds(20, 165, 450, 125);
        add(scroll2);

        JButton listMovies = new JButton("LIST");
        listMovies.setBounds(160, 300, 140, 30);
        add(listMovies);


        listMovies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataBox box = new DataBox("Regular movie", "LIST");
                Main.connect(box);
                String s = "";
                for(int i = 0; i < Main.movies.size(); i++){
                    s+=Main.movies.get(i).getId() + ") " + Main.movies.get(i).getName() + " " + Main.movies.get(i).getYear() + " " + Main.movies.get(i).getGenre() + " "+ Main.movies.get(i).getRating() +"\n";
                }
                area.setText(s);
                DataBox box1 = new DataBox("VIP movie", "LIST");
                Main.connect(box1);
                String s1 = "";
                for(int i = 0; i < Main.vipMovies.size(); i++){
                    s1+=Main.vipMovies.get(i).getId() + ") " + Main.vipMovies.get(i).getName() + " " + Main.vipMovies.get(i).getYear() + " " + Main.vipMovies.get(i).getGenre() + " "+ Main.vipMovies.get(i).getRating() +"\n";
                }
                area2.setText(s1);
            }
        });

        JLabel accessLabel = new JLabel("ACCESS:");
        accessLabel.setBounds(40, 345, 70, 30);
        add(accessLabel);

        JComboBox accessBox = new JComboBox(levels);
        accessBox.setBounds(115, 350, 100, 20);
        add(accessBox);


        JLabel indexLabel = new JLabel("INDEX:");
        indexLabel.setBounds(235, 345, 50, 30);
        add(indexLabel);

        JTextField indexText = new JTextField();
        indexText.setBounds(300, 345, 40, 30);
        add(indexText);

        JButton delete = new JButton("DELETE");
        delete.setBounds(360, 345, 100, 30);
        add(delete);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long index = Long.parseLong(indexText.getText());
                String access = (String)accessBox.getSelectedItem();
                if (access.compareTo("Regular") == 0){
                    DataBox box = new DataBox("Regular movie", "DELETE", index);
                    Main.connect(box);
                }else if (access.compareTo("VIP") == 0){
                    DataBox box = new DataBox("VIP movie", "DELETE", index);
                    Main.connect(box);
                }
                area.setText("");
                area2.setText("");
                indexText.setText("");
            }
        });

        JButton backButton = new JButton("GO BACK");
        backButton.setBounds(160, 390, 140, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.adminMenu.setVisible(true);
                Main.frame.deleteMovie.setVisible(false);
                area.setText("");
            }
        });





    }
}
