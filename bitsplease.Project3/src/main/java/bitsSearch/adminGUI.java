package bitsSearch;

import javax.swing.*;
import java.awt.*;



public class adminGUI {
    public adminGUI() {

        // create window
        Container con = new Container();
        JFrame adminWindow = new JFrame("GUI Admin");

        //add super cool icon
        ImageIcon kirby	= new ImageIcon("C:\\Users\\jendo\\OneDrive\\Pictures\\kirby.jpg");
        adminWindow.setIconImage(kirby.getImage());

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
        buttonPanel.setBounds(200, 350, 400, 50);
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
    }

}