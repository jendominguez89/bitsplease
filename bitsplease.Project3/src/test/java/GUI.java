import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * add booleans, add event listeners
 */
public class GUI {
    /*
     *   The fact that this function has no return declared, and
     *  it has the same name as the class, makes this a constructor.
     *  When you call this function in a program it will return a new
     *  instance of whatever object the class defines. Making things a seperate
     *  object usually makes it easier and safer to work with in large
     *  programs.
     */
    public GUI() {
        // set Fonts
        Font titleFont = new Font("Times New Roman", Font.BOLD, 50);
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 20);
        // make window
        Container con = new Container();
        javax.swing.JFrame adminWindow = new javax.swing.JFrame();
        adminWindow.setSize(800,600);
        adminWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        adminWindow.setLayout(null);
        adminWindow.setVisible(true);
        // content pane
        con = adminWindow.getContentPane();
        // title text
        JLabel titleLabel = new JLabel("BitsPlease Get Searching");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);
        // fabulous panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.pink);
        buttonPanel.setFont(buttonFont);
        buttonPanel.setBounds(200,450,400,50);
        con.add(buttonPanel);
        // buttons
        JButton addSearchInfo = new JButton("Search");
        JButton updateSearchInfo = new JButton("Update");
        JButton removeSearchInfo = new JButton("Delete");
        JButton adminButton = new JButton("Settings");
        adminButton.addActionListener(new ActionListener() {
            /* actionPerformed must be present, although it can
             * be defined in its own block
             */
            public void actionPerformed(ActionEvent e) {
                adminGUI admin = new adminGUI();
            }
        });
        buttonPanel.add(addSearchInfo);
        buttonPanel.add(updateSearchInfo);
        buttonPanel.add(removeSearchInfo);
        buttonPanel.add(adminButton);
    }
    /*
     *   Putting main in this file for now since its the first window
     *  to spawn, but we should consider leaving this as a class and
     *  making main its own file.
     */

    public static void main(String[] args) {
        GUI gui = new GUI();
        // adminGUI admin = new adminGUI();
    }
}
