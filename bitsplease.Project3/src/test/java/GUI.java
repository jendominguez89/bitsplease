import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args){
        Font titleFont = new Font ("Times New Roman", Font.BOLD, 50);
        Font buttonFont = new Font ("Times New Roman", Font.PLAIN, 20);
        Container con = new Container();
        javax.swing.JFrame adminWindow = new javax.swing.JFrame();
        adminWindow.setSize(800,600);
        adminWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);
        con = adminWindow.getContentPane();

        JLabel titleLabel = new JLabel("BitsPlease Get Searching");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.pink);
        buttonPanel.setFont(buttonFont);
        buttonPanel.setBounds(200,450,400,50);
        con.add(buttonPanel);
        JButton addSearchInfo = new JButton("Search");
        JButton updateSearchInfo = new JButton("Update");
        JButton removeSearchInfo = new JButton("Delete");
        buttonPanel.add(addSearchInfo);
        buttonPanel.add(updateSearchInfo);
        buttonPanel.add(removeSearchInfo);
    }
}
