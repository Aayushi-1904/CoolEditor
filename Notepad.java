package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    JFrame jFrame;
    JMenu file, edit, help, exit;
    JButton font_color, back_color;
    JMenuBar jMenuBar;
    JTextArea jTextArea;
    JMenuItem newFile, newWindow, open, save, print, cut, copy, paste, help_online, Exit;

    public Notepad() {
        jFrame = new JFrame("New File-Notepad");


        jFrame.setSize(1200, 1200);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);


        jTextArea = new JTextArea();
        jTextArea.setBounds(0, 0, 1000, 1200);


        jFrame.add(jTextArea);

        //Adding Buttons for added utilities
        font_color = new JButton("Font Colour");
        back_color = new JButton("Background Colour");


        font_color.setBounds(1000, 0, 150, 40);
        back_color.setBounds(1000, 300, 200, 40);
        jFrame.add(font_color);
        jFrame.add(back_color);


        //Setting font colour

        font_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                /ComboBox
                JButton b = new JButton("Apply");
                b.setBounds(1020, 250, 100, 40);

                JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
                checkBox1 = new JCheckBox("Red");
                checkBox2 = new JCheckBox("Green");
                checkBox3 = new JCheckBox("Blue");
                checkBox4 = new JCheckBox("Pink");
                checkBox1.setBounds(1020, 100, 150, 20);
                checkBox2.setBounds(1020, 120, 150, 20);
                checkBox3.setBounds(1020, 140, 150, 20);
                checkBox4.setBounds(1020, 160, 150, 20);


                jFrame.add(checkBox1);
                jFrame.add(checkBox2);
                jFrame.add(checkBox3);
                jFrame.add(checkBox4);

                JLabel jLabel = new JLabel("Selecting Font color ");
                jLabel.setBounds(1020, 80, 150, 20);

                jFrame.add(jLabel);
                jFrame.add(b);

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (checkBox1.isSelected()) {
                            jTextArea.setForeground(Color.RED);

                        } else if (checkBox2.isSelected()) {
                            jTextArea.setForeground(Color.GREEN);
                        } else if (checkBox3.isSelected()) {

                            jTextArea.setForeground(Color.BLUE);

                        } else {

                            jTextArea.setForeground(Color.PINK);

                        }

                        JOptionPane.showMessageDialog(jFrame, "Font Colour Changed");
                    }
                });

            }
        });


        //Selecting Background colour
        back_color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                /ComboBox
                JButton b = new JButton("Apply");
                b.setBounds(1020, 450, 100, 40);

                JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
                checkBox1 = new JCheckBox("Black");
                checkBox2 = new JCheckBox("White");
                checkBox3 = new JCheckBox("Cyan");
                checkBox4 = new JCheckBox("Pink");
                checkBox1.setBounds(1020, 350, 150, 20);
                checkBox2.setBounds(1020, 370, 150, 20);
                checkBox3.setBounds(1020, 390, 150, 20);
                checkBox4.setBounds(1020, 410, 150, 20);


                jFrame.add(checkBox1);
                jFrame.add(checkBox2);
                jFrame.add(checkBox3);
                jFrame.add(checkBox4);

//                JLabel jLabel = new JLabel("Selecting Backgroucolor ");
//                jLabel.setBounds(1420, 80, 150, 20);

//                jFrame.add(jLabel);
                jFrame.add(b);

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (checkBox1.isSelected()) {
                            jTextArea.setBackground(Color.BLACK);

                        } else if (checkBox2.isSelected()) {
                            jTextArea.setBackground(Color.WHITE);
                        } else if (checkBox3.isSelected()) {

                            jTextArea.setBackground(Color.CYAN);

                        } else {

                            jTextArea.setBackground(Color.PINK);

                        }

                        JOptionPane.showMessageDialog(jFrame, "Background Colour Changed");
                    }
                });

            }
        });
        jFrame.add(back_color);

        //creating menubar
        jMenuBar = new JMenuBar();


//        JMenu jMenu = new JMenu("File")

        file = new JMenu("File");
        edit = new JMenu("Edit");
        exit = new JMenu("Exit");
        help = new JMenu("Help");

//        File= new JMenu("File");


        //Creating menuItems
        newFile = new JMenuItem("New");
        newWindow = new JMenuItem("New Window");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        print = new JMenuItem("Print");

        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        print.addActionListener(this);
        newWindow.addActionListener(this);

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(newWindow);

        edit = new JMenu("Edit");

        // Create menu items
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        // Add action listener
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);


        edit.add(cut);
        edit.add(copy);
        edit.add(paste);


//        exit.addActionListener();
        Exit = new JMenuItem("Exit");
        exit.add(Exit);
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(jFrame, "Do you want to exit?");
                if (a == JOptionPane.YES_OPTION) {
//                    jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
                    jFrame.dispose();
                }

            }
        });

        help_online = new JMenuItem("Help");
        help_online.addActionListener(this);
        help.add(help_online);

        jMenuBar.add(file);
        jMenuBar.add(edit);
        jMenuBar.add(exit);
        jMenuBar.add(help);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.setVisible(true);
        jTextArea.setVisible(true);
        font_color.setVisible(true);
        back_color.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Cut")) {
            jTextArea.cut();
        } else if (s.equals("Copy")) {
            jTextArea.copy();
        } else if (s.equals("Paste")) {
            jTextArea.paste();
        } else if (s.equals("Save")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");

            // Invoke the showsSaveDialog function to show the save dialog
            int r = j.showSaveDialog(null);

            if (r == JFileChooser.APPROVE_OPTION) {

                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    // Create a file writer
                    FileWriter wr = new FileWriter(fi, false);

                    // Create buffered writer to write
                    BufferedWriter w = new BufferedWriter(wr);

                    // Write
                    w.write(jTextArea.getText());

                    w.flush();
                    w.close();
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(jFrame, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else JOptionPane.showMessageDialog(jFrame, "The user cancelled the operation");
        } else if (s.equals("Print")) {
            try {
                // print the file
                jTextArea.print();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(jFrame, evt.getMessage());
            }
        } else if (s.equals("Open")) {
            // Create an object of JFileChooser class
            JFileChooser j = new JFileChooser("f:");

            // Invoke the showsOpenDialog function to show the save dialog
            int r = j.showOpenDialog(null);

            // If the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // Set the label to the path of the selected directory
                File fi = new File(j.getSelectedFile().getAbsolutePath());

                try {
                    // String
                    String s1 = "", sl = "";

                    // File reader
                    FileReader fr = new FileReader(fi);

                    // Buffered reader
                    BufferedReader br = new BufferedReader(fr);

                    // Initialize sl
                    sl = br.readLine();

                    // Take the input from the file
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }

                    // Set the text
                    jTextArea.setText(sl);
                } catch (Exception evt) {
                    JOptionPane.showMessageDialog(jFrame, evt.getMessage());
                }
            }
            // If the user cancelled the operation
            else JOptionPane.showMessageDialog(jFrame, "the user cancelled the operation");
        } else if (s.equals("New")) {
            jTextArea.setText("");
        } else if (s.equals("New Window")) {
            jFrame.dispose();
            new Notepad();
        } else if (s.equals("Help")) {
            JOptionPane.showMessageDialog(jFrame, "For better experience, read more about Swings and related Java Frameworks ");
        }


    }

    public static void main(String[] args) {
        Notepad n = new Notepad();
    }


}
