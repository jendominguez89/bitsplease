package bitsSearch;

import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import java.awt.*;

public class adminGUI {
    private String doesNothing () {return "Nothing here to see"};
    public adminGUI() {
        String PathTesting = ("D:\\InteliJ\\bitsplease\\bitsplease.Project3\\src\\test\\TestResource\\PathTesting");
        // create window
        Container con = new Container();
        JFrame adminWindow = new JFrame();
        //set fonts
        Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
        Font anchorFont = new Font("Times New Roman", Font.PLAIN, 16);
        // set layout and resolution
        adminWindow.setSize(800, 600);
        /*
         *  Turns out when you close the admin window, the search window
         *  also closes. To stop this, we change EXIT_ON_CLOSE to
         *  DISPOSE_ON_CLOSE.
         */
        adminWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);
        // make content pane
        con = adminWindow.getContentPane();
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
            public void actionPerformed(ActionEvent e) { doesNothing();
            }
        });

        updateFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { doesNothing();
            }
        });

        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { doesNothing();
            }
        });


        //Class that defines what data is collected for our JSon file.
        class indexFile {
           String name;
           String modifyDate;
           boolean wasModified;
        }

        // function that reads files and writes the data to a JSon file.
        public void writeFilesToJson (String fileName) throws FileNotFoundException {
            indexFile file = new indexFile();
            Gson gson = new Gson();
            String json = gson.toJson(file);

        }

    }
}



47