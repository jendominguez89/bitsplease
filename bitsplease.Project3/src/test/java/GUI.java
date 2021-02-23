import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * add radio buttons
 */
public class GUI {
    /*
        placeholder values for testing, these will be
        likely be replaced or removed in later versions
     */
    private String placeholder = "unset";

    private String stubMethod() {
        return "Area under Construction";
    }
    /* parses radio button choice */
    private String radioHook(String radio) {
        return "Your boolean is in a different castle.";
    }

    /*  This function adds radio buttons to the content pane for
        our boolean selector. It does not return a value, but objects
        are passed by reference in Java. This means the function operates on
        the same content pane as the constructor does, and any changes
        made here affect the rest of the program.
     */
    private void addRadioButtons(Container content) {
        /* and button, selected by default */
        JRadioButton andButton = new JRadioButton("And");
        andButton.setActionCommand("AND");
        andButton.setSelected(true);
        /* or button */
        JRadioButton orButton = new JRadioButton("Or");
        orButton.setActionCommand("OR");
        /* exact match button, refered to as 'match' */
        JRadioButton matchButton = new JRadioButton("Exact Match");
        matchButton.setActionCommand("MATCH");

        // group da buttons
        ButtonGroup group = new ButtonGroup();
        group.add(andButton);
        group.add(orButton);
        group.add(matchButton);

        /*  action listeners, the string can be used as the control value
            for a switch case in the parsing function
         */
        andButton.addActionListener(new ActionListener() {
           public void actionPerformed( ActionEvent e ) {
               radioHook(andButton.getActionCommand());
           }
        });
        orButton.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                radioHook(orButton.getActionCommand());
            }
        });
        matchButton.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent e ) {
                radioHook(matchButton.getActionCommand());
            }
        });
    }

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

        // radio buttons
        JPanel radio = new JPanel();

        // fabulous panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.pink);
        buttonPanel.setFont(buttonFont);
        buttonPanel.setBounds(200,450,400,50);
        con.add(buttonPanel);

        // regular buttons
        JButton addSearchInfo = new JButton("Search");
        addSearchInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeholder = stubMethod();
            }
        });
        JButton updateSearchInfo = new JButton("Update");
        updateSearchInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeholder = stubMethod();
            }
        });
        JButton removeSearchInfo = new JButton("Delete");
        removeSearchInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                placeholder = stubMethod();
            }
        });
        JButton adminButton = new JButton("Settings");
        adminButton.addActionListener(new ActionListener() {
            /* actionPerformed must be present, although it can
             * be defined in its own block
             */
            public void actionPerformed(ActionEvent e) {
                adminGUI admin = new adminGUI(); // creates admin window
            }
            /*  Normally you wouldn't need a semicolon after a }
                but this is still contained in a parenthesis, so
                we have to close. After you the ) you *do* need
                the semicolon.
             */
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
