package com.mycompany.resortpricecalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Layout extends JFrame {

    private JTextField guestName;
    private JLabel b, c, d, gName, Text;
    private JCheckBox r1, r2, r3;
    private JButton cal;
    private JComboBox Box;

    Layout() {
        setTitle("Resort Price Calculator");
        setLocationRelativeTo(null);
        
           
        
        b = new JLabel("Resort Price Calculator");
        b.setFont(new Font("Times New Roman", Font.PLAIN, 40));       
        c = new JLabel("Base price for a room is $200");
        c.setFont(new Font("Times New Roman", Font.PLAIN, 25));       
        d = new JLabel("Choose obtions that you want");
        d.setFont(new Font("Times New Roman", Font.PLAIN, 28));        
        gName = new JLabel("Guest Name:");        
        guestName = new JTextField(20);
        Text = new JLabel("");
        r1 = new JCheckBox("Breakfast 20$");
        r2 = new JCheckBox("Goft $50");
        r3 = new JCheckBox("Pool $15");
        String pr[] = {"Week day (-10%)", "Weekend (+30%)"};
        Box = new JComboBox(pr);       
        cal = new JButton("Calculate");
        
        
        
        
        
        add(b);
        add(c);
        add(d);
        add(gName);
        add(guestName);
        add(Text);
        add(r1);
        add(r2);
        add(r3);
        add(Box);
        add(cal);
        
        
        cal.addActionListener(e -> calculate());
        pack();
        setSize(400, 350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void calculate() {
        String name = guestName.getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter guest name!");
            return;
        }
        double total = 200;
        if (r1.isSelected()) {
            total += 20;
        }
        if (r2.isSelected()) {
            total += 50;
        }
        if (r3.isSelected()) {
            total += 15;
        }
        if (Box.getSelectedIndex() == 0) {
            total = total - total * 0.1;
        } else {
            total = total + total * 0.3;
        }

        Text.setText("Hello " + name + " Your payment is:$" + total);
        Text.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        add(Text);
    }
}
