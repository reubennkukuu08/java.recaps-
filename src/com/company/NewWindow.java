package com.company;
import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame{
    JLabel label;

    NewWindow(){
        label = new JLabel("About: Notepad 2.95 - 2022");
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null,Font.PLAIN,25));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,420);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        add(label);
    }

}
