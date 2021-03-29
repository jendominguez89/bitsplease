

package bitsSearch;

import bitsSearch.models.IndexFile;
import bitsSearch.repositories.FileRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class AdminGUI2 {
    private List<IndexFile> files = new ArrayList<>();
    private FileRepository fileRepository = new FileRepository();
    private void doesNothing (){}

    public AdminGUI2() {
        try {
            files = fileRepository.load();
            for(IndexFile f:files){
                // file has been changed for every file that != exist
                // print files do not exist
                System.out.println("The file you are searching for was removed and does not exist.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

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
        tablePanel.setBounds(180, 200, 400, 200);
        con.add(tablePanel);
        JTable table = new JTable(3, 3);
        table.getColumnModel().getColumn(0).setHeaderValue("File Name");
        table.getColumnModel().getColumn(1).setHeaderValue("File Status");
        table.getColumnModel().getColumn(2).setHeaderValue("File Date");
        JScrollPane sp = new JScrollPane(table);
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

    public void SelectFile () {
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
                try {
                    IndexFile f = new IndexFile();
                    f.setIndexTime(Date.from(Instant.now()));
                    f.setFileName(selectedFile.getCanonicalPath());
                    this.files.add(f);
                    this.fileRepository.save(this.files);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            System.exit(0);
        });
        
    }


    public static void main(String[] args) {
        AdminGUI2 admin = new AdminGUI2();
    }
}