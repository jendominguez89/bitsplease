package bitsSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    /*
        placeholder values for testing, these will be
        likely be replaced or removed in later versions
     */
    private String placeholder = "unset";
    private String booleanValue = "AND";

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
        the actual object you pass it, not a copy. This allows us to
        affect things outside the scope of the function. Any changes
        made here affect the rest of the program. I would like this
        kind of thing to be it's own file eventually. For now I'll
        maintain a code style similar to the rest of the group.
     */
    private void addRadioButtons(JPanel jpanel) {
        /* and button, selected by default */
        JRadioButton andButton = new JRadioButton("And");
        andButton.setActionCommand("AND");
        andButton.setSelected(true);
        /* or button */
        JRadioButton orButton = new JRadioButton("Or");
        orButton.setActionCommand("OR");
        /* exact match button, referred to as 'match' */
        JRadioButton matchButton = new JRadioButton("Exact Match");
        matchButton.setActionCommand("MATCH");

        // group da buttons
        ButtonGroup group = new ButtonGroup();
        group.add(andButton);
        group.add(orButton);
        group.add(matchButton);

        /*  Action listeners, the string can be used as the control value
            for a switch case in the parsing function. This is a good candidate
            for a do over. Using isSelected() might be easier to understand
            and it'll probably be less to read.
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
        jpanel.add(andButton);
        jpanel.add(orButton);
        jpanel.add(matchButton);
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
        Container con;
        javax.swing.JFrame searchWindow = new javax.swing.JFrame("BitsPlease Search Tool");
        ImageIcon link	= new ImageIcon(getClass().getResource("/link.jpg"));
        searchWindow.setIconImage(link.getImage());
        searchWindow.setSize(800,600);
        searchWindow.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        searchWindow.setLayout(null);
        searchWindow.setVisible(true);

        // content pane
        con = searchWindow.getContentPane();

        // title text
        JLabel titleLabel = new JLabel("BitsPlease Get Searching");
        titleLabel.setFont(titleFont);
        JPanel titlePanel = new JPanel();
        con.add(titlePanel);
        titlePanel.setBounds(40, 10, 700, 100);
        titlePanel.add(titleLabel);

        // textbox
        JPanel textPanel = new JPanel(new BorderLayout());
        //textPanel.setBackground(Color.blue);
        textPanel.setBounds(100, 150, 600, 35);
        JTextField textBox = new JTextField(25); // arg != hard limit
        textPanel.add(textBox,BorderLayout.CENTER);
        textBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                placeholder = textBox.getText();
            }
        });

        JLabel textLabel = new JLabel("Enter Search Term Here:  ");
        textPanel.add(textLabel,BorderLayout.WEST);
        con.add(textPanel);

        // radio buttons
        // panel to put them on
        JPanel radioPanel = new JPanel();
        radioPanel.setBounds(300, 200, 200, 50);
        addRadioButtons(radioPanel);
        con.add(radioPanel);

        // regular panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setFont(buttonFont);
        buttonPanel.setBounds(200,450,400,50);
        con.add(buttonPanel);

        // real buttons
        JButton addSearchInfo = new JButton("Search");
        addSearchInfo.addActionListener(new ActionListener() {
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
        buttonPanel.add(adminButton);

        /*  Adding elements is turning the window blank. This should
            stop it for the moment but the error means we should change the
            way we instantiate the window.

         */
        searchWindow.invalidate();
        searchWindow.validate();
        searchWindow.repaint();
        textBox.requestFocusInWindow();
    }
    /*
     *   Putting main in this file for now since its the first window
     *  to spawn, but we should consider leaving this as a class and
     *  making main its own file.
     */

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
