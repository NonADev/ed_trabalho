package main.ed_sis.domain.table;

import javax.swing.*;

public class tab_ {
    tab_() {
        JFrame f = new JFrame();

        f.setTitle("JTable Example");

        String[][] data = {
                {"Kundan Kumar Jha", "4031", "CSE"},
                {"Anand Jha", "6014", "IT"}
        };

        String[] columnNames = {"Name", "Roll Number", "Department"};

        JTable j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        new tab_();
    }
}
