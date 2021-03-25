package bitsSearch;

import com.google.gson.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Type;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AdminGUI {
    //Added field to hold file for function for testing purposes.


    private String doesNothing () {return "Nothing here to see";}

    public AdminGUI() {

        String PathTesting = ("D:\\InteliJ\\bitsplease\\bitsplease.Project3\\src\\test\\TestResource\\PathTesting");
        // create window
        Container con = new Container();
        JFrame AdminWindow = new JFrame();
        //set fonts
        Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
        Font anchorFont = new Font("Times New Roman", Font.PLAIN, 16);
        // set layout and resolution
        AdminWindow.setSize(800, 600);
        /*
         *  Turns out when you close the admin window, the search window
         *  also closes. To stop this, we change EXIT_ON_CLOSE to
         *  DISPOSE_ON_CLOSE.
         */
        AdminWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AdminWindow.setLayout(null);
        AdminWindow.setVisible(true);
        // make content pane
        con = AdminWindow.getContentPane();
        // add title
        JLabel titleLabel = new JLabel("BitsPlease Search Engine");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);
        // add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(200, 400, 400, 50);
        con.add(buttonPanel);
        JButton addFile = new JButton("Add File");
        JButton updateFile = new JButton("Update");
        JButton removeFile = new JButton("Remove File");
        buttonPanel.add(addFile);
        buttonPanel.add(updateFile);
        buttonPanel.add(removeFile);
        // adds flavor text
        JPanel anchorPanel = new JPanel();
        anchorPanel.setBounds(200, 500, 400, 50);
        JLabel anchorText = new JLabel("Searching since 2021");
        anchorText.setFont(anchorFont);
        anchorPanel.add(anchorText);
        con.add(anchorPanel);


        //Button functionality for future use.
        removeFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    IndexFile.writeToJson(IndexFile.file);
                } catch (IOException ioException) {
                    System.out.println("No can dooski brudda");
                }
            }
        });

        updateFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doesNothing();
            }
        });

        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doesNothing();
            }
        });
    }
}



