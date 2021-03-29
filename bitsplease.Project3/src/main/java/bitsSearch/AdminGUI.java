package bitsSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class AdminGUI {
    private String doesNothing () {return "Nothing here to see";}
    public AdminGUI() {

        // create window
        Container con = new Container();
        JFrame AdminWindow = new JFrame("GUI Admin");

        // add super cool icon
        ImageIcon kirbs	= new ImageIcon(getClass().getResource("/kirbs.jpg"));
        AdminWindow.setIconImage(kirbs.getImage());

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

        // adding table
        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(180,150,400,200);
        con.add(tablePanel);
        JTable table = new JTable(6,3);
        table.getColumnModel().getColumn(0).setHeaderValue("File Name");
        table.getColumnModel().getColumn(1).setHeaderValue("File Status");
        table.getColumnModel().getColumn(2).setHeaderValue("File Date");
        JScrollPane sp=new JScrollPane(table);
        tablePanel.add(sp);
        tablePanel.setVisible(true);

        // add buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(185, 350, 400, 50);
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

        // select files for indexing
        removeFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doesNothing();
            }
        });

        updateFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doesNothing();
            }
        });

        addFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {SelectFile();
            }
        });
    }
        public static void SelectFile () {
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ignored) {
                }
                JFileChooser fileChooser = new JFileChooser(".");
                int status = fileChooser.showOpenDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected: " + selectedFile.getParent()
                            + " --- " + selectedFile.getName());
                }
                System.exit(0);
            });


        }
}