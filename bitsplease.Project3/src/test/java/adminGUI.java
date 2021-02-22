import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class adminGUI {
    public static void main (String[] args) {
        Container con = new Container();

        /*setting the properties of the webpage*/
        JFrame adminWindow = new JFrame();
        Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
        Font anchorFont = new Font("Times New Roman", Font.PLAIN, 16);
        adminWindow.setSize(800,600 );
        adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);
        con = adminWindow.getContentPane();
        JLabel titleLabel = new JLabel("BitsPlease Search Engine");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);

        /*adding non-functioning buttons to page*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(180,300, 400,50);
        con.add(buttonPanel);
        JButton addFile = new JButton("Add File");
        JButton updateFile = new JButton("Update");
        JButton removeFile = new JButton("Remove File");
        buttonPanel.add(addFile);
        buttonPanel.add(updateFile);
        buttonPanel.add(removeFile);

        /* adding footnotes */
        JPanel anchorPanel = new JPanel();
        anchorPanel.setBounds(180,500,400, 50);
        JLabel anchorText = new JLabel("Searching since 2021");
        anchorText.setFont(anchorFont);
        anchorPanel.add(anchorText);
        con.add(anchorPanel);
    }

}