package com.company;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    //JMenu formatMenu;
    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    JMenuItem copyItem;
    JMenuItem cutItem;
    JMenuItem pasteItem;
    //JMenuItem fontItem;
    JMenuItem zoomItem;
    JMenuItem viewHelpItem;
    JMenuItem feedBackItem;
    JMenuItem aboutItem;

    JTextArea textArea;
    JScrollPane scrollPane;
    //JSpinner fontSizeSpinner;

    public MyFrame (){
        menuBar = new JMenuBar(); //menu bar
        textArea = new JTextArea();
        //textArea.setPreferredSize(new Dimension(450,450));
        //now with scrollpane no need for the above code in the textArea
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        scrollPane = new JScrollPane(textArea); //we add the textArea to the scrollPane
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //fontSizeSpinner = new JSpinner();
        //fontSizeSpinner.setPreferredSize(new Dimension(50,20));
        //fontSizeSpinner.setValue(14);
        //fontSizeSpinner.addChangeListener(new ChangeListener() {
        // @Override
        //public void stateChanged(ChangeEvent e) {
        //textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN, (Integer) fontSizeSpinner.getValue()));
        //}
        //});
        //initializing the menus
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        //formatMenu = new JMenu("Format");
        //initializing the menu items
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        copyItem = new JMenuItem("Copy");
        cutItem = new JMenuItem("Cut");
        pasteItem = new JMenuItem("Paste");
        //fontItem = new JMenuItem("Font");
        viewHelpItem = new JMenuItem("View Help");
        feedBackItem = new JMenuItem("Send Feedback");
        aboutItem = new JMenuItem("About Notepad");
        //adding actionListeners to the menuItems
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        cutItem.addActionListener(this);
        aboutItem.addActionListener(this);
        //setting mnemonics to the actions
        fileMenu.setMnemonic(KeyEvent.VK_F); //Alt + F for File
        editMenu.setMnemonic(KeyEvent.VK_E); //Alt + E for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); //Alt + H for help
        newItem.setMnemonic(KeyEvent.VK_N);

        //adding the menus to the MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        // menuBar.add(fontSizeSpinner);
        //adding the menuItems
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);
        helpMenu.add(aboutItem);


        setTitle("@reubennkukuu08 (text-editor)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setVisible(true);
        setJMenuBar(menuBar); //setting the Menu Bar to the Frame
        //add(textArea);   now no need of adding the textArea to the frame
        add(scrollPane);
        //add(fontSizeSpinner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem){
            setTitle("Untitled.txt - Notepad");
            textArea.setText("");
        }
        if (e.getSource() == exitItem) {
            System.exit(0);
        }
        if (e.getSource() == openItem){

        }

        if (e.getSource() == saveItem){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter fileOut = null;
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());
                    setTitle(file.getName() + " - Notepad");

                }catch (FileNotFoundException e1){
                    e1.printStackTrace();
                }finally {
                    fileOut.close();
                }
            }

        }
        if (e.getSource() == copyItem){
            textArea.copy();
        }
        if (e.getSource() == pasteItem){
            textArea.paste();
        }
        if (e.getSource() == cutItem){
            textArea.cut();
        }
        if (e.getSource() == aboutItem){
            JOptionPane.showMessageDialog(this,"Notepad 22 - Created by reubennkukuu08");
        }

    }
}
