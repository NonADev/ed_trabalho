package main.ed_sis.domain.table;

import javax.swing.*;

public class tab_ {
    tab_() {
        // Frame initiallization
        JFrame f = new JFrame();

        // Frame Title
        f.setTitle("JTable Example");

        // Data to be displayed in the JTable
        String[][] data = {
                {"Kundan Kumar Jha", "4031", "CSE"},
                {"Anand Jha", "6014", "IT"}
        };

        // Column Names
        String[] columnNames = {"Name", "Roll Number", "Department"};

        // Initializing the JTable
        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new tab_();
    }
}
