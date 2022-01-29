package com.company;
import javax.naming.Name;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class dataBaseConnect extends JFrame implements ActionListener {

    JLabel label1,label2,label3,label4;
    JTextField textField1,textField2,textField3,textField4;
    JButton addbtn,displaybtn,deletebtn,updatebtn,clearbtn;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel model;

    public dataBaseConnect(){

        label1 = new JLabel("ID: ");
        label1.setBounds(100,40,100,30);
        label2 = new JLabel("REG NO: ");
        label2.setBounds(100,80,100,30);
        label3 = new JLabel("NAME: ");
        label3.setBounds(100,120,100,30);
        label4 = new JLabel("COURSE: ");
        label4.setBounds(100,160,100,30);
        textField1 = new JTextField(5);
        textField1.setBounds(200,40,200,30);
        textField2 = new JTextField();
        textField2.setBounds(200,80,200,30);
        textField3 = new JTextField();
        textField3.setBounds(200,120,200,30);
        textField4 = new JTextField();
        textField4.setBounds(200,160,200,30);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(50,260,450,200);

        table = new JTable();
        table.setBackground(new Color(190,180,222));
        model = new DefaultTableModel();
        Object[] column = {"ID","ADM NO", "NAME","COURSE"};
        //final Object[] row = new Object[4];
        model.setColumnIdentifiers(column); //sets names of the columns
        table.setModel(model);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                textField1.setText(model.getValueAt(i,0).toString());
                textField2.setText(model.getValueAt(i,1).toString());
                textField3.setText(model.getValueAt(i,2).toString());
                textField4.setText(model.getValueAt(i,3).toString());

            }
        });

        displaybtn = new JButton("Display");
        displaybtn.addActionListener(this);
        displaybtn.setBounds(50,200,90,30);
        displaybtn.setFocusable(false);
        addbtn = new JButton("Add");
        addbtn.addActionListener(this);
        addbtn.setBounds(150,200,70,30);
        addbtn.setFocusable(false);
        deletebtn = new JButton("Delete");
        deletebtn.addActionListener(this);
        deletebtn.setBounds(250,200,70,30);
        deletebtn.setFocusable(false);
        updatebtn = new JButton("Update");
        updatebtn.addActionListener(this);
        updatebtn.setBounds(350,200,80,30);
        updatebtn.setFocusable(false);
        clearbtn = new JButton("Clear");
        clearbtn.addActionListener(this);
        clearbtn.setBounds(450,200,70,30);
        clearbtn.setFocusable(false);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("reubennkukuu08");
        setSize(550,550);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(textField1);
        add(textField2);
        add(textField3);
        add(textField4);
        add(scrollPane);
        add(displaybtn);
        add(addbtn);
        add(updatebtn);
        add(deletebtn);
        add(clearbtn);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == addbtn){
            int id = Integer.parseInt(textField1.getText());
            String regNo = textField2.getText();
            String name = textField3.getText();
            String course = textField4.getText();
            Insert(id,regNo,name,course);
            model.setRowCount(0);
            Display();

            if (textField1.getText().equals("") || textField2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
            }
            JOptionPane.showMessageDialog(null,"Data inserted Successfully");
        }
        if(e.getSource() == updatebtn){
            int id = Integer.parseInt(textField1.getText());
            String regNo = textField2.getText();
            String name = textField3.getText();
            String course = textField4.getText();
            Update(id,regNo,name,course);
            model.setRowCount(0);
            Display();

            JOptionPane.showMessageDialog(null,"Record Successfully Updated");
        }
        if(e.getSource() == deletebtn){
            int id = Integer.parseInt(textField1.getText());
            Delete(id);
            model.setRowCount(0);
            Display();

            JOptionPane.showMessageDialog(null,"Record deleted Successfully");
        }
        if(e.getSource() == displaybtn){
            model.setRowCount(0);
            Display();
            //displaybtn.setEnabled(false);
        }
        if (e.getSource() == clearbtn){
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            model.setRowCount(0);
        }
    }

public void Insert(int Id,String RegNo,String Name1,String Course) {

        String studentInfo = "insert into stud(id,regNo,name,course)values(?,?,?,?)";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reubennkukuu08","root","QWER5678");

            PreparedStatement preparedStatement = connection.prepareStatement(studentInfo);
            preparedStatement.setInt(1,Id);
            preparedStatement.setString(2,RegNo);
            preparedStatement.setString(3,Name1);
            preparedStatement.setString(4,Course);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void Display(){

        String studentInfo2 = "select * from stud";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reubennkukuu08","root","QWER5678");

            PreparedStatement preparedStatement = connection.prepareStatement(studentInfo2);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id1 = String.valueOf(resultSet.getInt("ID"));
                String reNo1 = resultSet.getString("REGNO");
                String name1 = resultSet.getString("NAME");
                String course1 = resultSet.getString("COURSE");

                String[] tbData ={id1,reNo1,name1,course1};
                model.addRow(tbData);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void Update(int Id,String RegNo,String Name1,String Course) {

        String studentUpdate = "update stud set id= ?, regNo= ?, name= ?, course= ? where id= ?";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reubennkukuu08","root","QWER5678");

            PreparedStatement preparedStatement = connection.prepareStatement(studentUpdate);
            preparedStatement.setInt(1,Id);
            preparedStatement.setString(2,RegNo);
            preparedStatement.setString(3,Name1);
            preparedStatement.setString(4,Course);
            preparedStatement.setInt(5,Id);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void Delete(int Adm) {

        String studentUpdate = "delete from stud where id= ?";
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reubennkukuu08","root","QWER5678");

            PreparedStatement preparedStatement = connection.prepareStatement(studentUpdate);
            preparedStatement.setInt(1,Adm);
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
