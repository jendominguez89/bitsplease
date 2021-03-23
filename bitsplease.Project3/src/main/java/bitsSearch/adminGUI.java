

package bitsSearch;

import bitsSearch.models.IndexModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class adminGUI {
    public adminGUI() {

        // create window
        Container con = new Container();
        JFrame adminWindow = new JFrame("GUI Admin");

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

        // adding table
           JPanel tablePanel = new JPanel();
           tablePanel.setBounds(180,200,400,200);
           con.add(tablePanel);
           JTable table = new JTable(3,3);
           table.getColumnModel().getColumn(0).setHeaderValue("File Name");
           table.getColumnModel().getColumn(1).setHeaderValue("File Status");
           table.getColumnModel().getColumn(2).setHeaderValue("File Date");
           JScrollPane sp=new JScrollPane(table);
           tablePanel.add(sp);
           tablePanel.setVisible(true);

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
        addFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IndexModel im = new IndexModel();
                //type from string to set of strings set index is taking a hashmap ... (variable index)
                HashMap<String, Set<String>> index = new HashMap<String, Set<String>>();
                HashSet<String> Set = new HashSet<>();
                Set.add("Annie On My Mind");
                index.put("Bear", Set);
                im.setIndex(index);
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    objectMapper.writeValue(new File("c:\\Users\\sschl\\Desktop\\out\\index.json"),im);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    IndexModel im2 = objectMapper.readValue(new File("c:\\Users\\sschl\\Desktop\\out\\index.json"),IndexModel.class);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        // adds flavor text
        JPanel anchorPanel = new JPanel();
        anchorPanel.setBounds(200, 500, 400, 50);
        JLabel anchorText = new JLabel("Searching since 2021");
        anchorText.setFont(anchorFont);
        anchorPanel.add(anchorText);
        con.add(anchorPanel);
    }
    public static void main(String[] args) {
        adminGUI admin = new adminGUI();
    }
}