package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class computeAge extends JFrame implements ActionListener {

    JLabel label1,label2,label3;
    JTextField field1,field2,field3;
    JButton button1, button2;
    public computeAge(){
        label1 = new JLabel("Year of Birth: ");
        label1.setBounds(100,100,100,30);
        label2 = new JLabel("Age: ");
        label2.setBounds(100,150,100,30);
        label3 = new JLabel("Age Group: ");
        label3.setBounds(100,200,100,30);


        field1 = new JTextField(5);
        field1.setBounds(200,100,200,30);
        field2 = new JTextField();
        field2.setBounds(200,150,200,30);
        field3 = new JTextField();
        field3.setBounds(200,200,200,30);

        button1 = new JButton("COMPUTE");
        button1.setBounds(130,250,100,30);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button2 = new JButton("EXIT");
        button2.setBounds(250,250,100,30);
        button2.setFocusable(false);
        button2.addActionListener(this);







        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,450);
        setVisible(true);
        setTitle("@reubennkukuu08");
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(field1);
        add(field2);
        add(field3);
        add(button1);
        add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1){
            LocalDate date = LocalDate.now();
            String year = date.format(DateTimeFormatter.ofPattern("yyyy"));

            int yob = Integer.parseInt(field1.getText());
            int current = Integer.parseInt(year);
            int age = current - yob;

            String tbd = String.valueOf(age);
            field2.setText("Your age is  " + tbd);

            if (age < 13){
                field3.setText("Kid");
            }else if (age <= 19){
                field3.setText("Teenager");
            }else if( age > 20){
                field3.setText("Adult");
            }//else if (age > 100)
                //field3.setText("Ancestor");
            //field2.setText("Age out of Range");
        }
        if (e.getSource() == button2){
            System.exit(0);
        }
    }
}
