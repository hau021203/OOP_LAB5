package com.mycompany.lab4cdstore;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class CDStore extends JFrame {

    private ArrayList<MenuEdit> CDs;
    private JLabel Id, Title, Collection, Price, Year, Type;
    private JButton Add, Clear, Showall;
    private JComboBox BCollection;
    private JRadioButton VCD, CD;
    private JTextField TId, TTitle, TPrice, TYear;
    private JTable Table;
    private ArrayList<MenuEdit> Menu;
    private DefaultListModel CdlistModel;
    private JScrollPane listScrollPane;
    private JList CDlist;

    public CDStore() {
        setTitle("CD Store");
        setLayout(new FlowLayout());
        Id = new JLabel("CD ID");
        Title = new JLabel("CD Title");
        Collection = new JLabel("CD Collection");
        Price = new JLabel("CD Price");
        Year = new JLabel("CD Year of Release");
        Type = new JLabel("CD Type");
        Add = new JButton("Add");
        Clear = new JButton("Clear");
        Showall = new JButton("Show All");
        String Col[] = {"game", "movie", "music"};
        BCollection = new JComboBox(Col);
        VCD = new JRadioButton("VCD");
        CD = new JRadioButton("CD");
        ButtonGroup gr = new ButtonGroup();
        gr.add(VCD);
        gr.add(CD);
        TId = new JTextField(25);
        TTitle = new JTextField(25);
        TPrice = new JTextField(23);
        TYear = new JTextField(30);
        CdlistModel = new DefaultListModel();
        CDlist = new JList(CdlistModel);
        listScrollPane = new JScrollPane(CDlist);

        add(Id);
        add(TId);
        add(Title);
        add(TTitle);
        add(Collection);
        add(BCollection);
        add(Type);
        add(VCD);
        add(CD);
        add(Price);
        add(TPrice);
        add(Year);
        add(TYear);
        add(Add);
        add(Clear);
        add(Showall);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setVisible(true);

        Add.addActionListener(e -> Add());
        Clear.addActionListener(e -> Clear());
        Showall.addActionListener(e -> Show());
        Menu = new ArrayList<>();
        load();
    }

    public void Add() {
        String CDId = TId.getText();
        String Title = TTitle.getText();
        String CDCollection = (String) BCollection.getSelectedItem();
        String CDType;
        if (VCD.isSelected()) {
            CDType = "VCD";
        } else {
            CDType = "CD";
        }
        int Price = Integer.parseInt(TPrice.getText());
        int YearOfRe = Integer.parseInt(TYear.getText());
        MenuEdit list = new MenuEdit(CDId, CDCollection, CDType, Title, Price, YearOfRe);
        Menu.add(list);
        CdlistModel.addElement(list.OutputCD());
        if (true) {
            JOptionPane.showMessageDialog(this, "Adding Successful");
        }else
            JOptionPane.showMessageDialog(this, "Adding Fail");
        save();
        Clear();
    }

    public void Clear() {
        TId.setText("");
        TTitle.setText("");
        TPrice.setText("");
        TYear.setText("");
    }

    public void Show() {
        JFrame a = new JFrame();
        a.add(listScrollPane);
        a.setLayout(new GridBagLayout());
        a.setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setVisible(true);
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("CDStore.hau"))) {
            oos.writeObject(Menu);
            oos.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving employees to file.");
        }
    }

    private void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("CDStore.hau"))) {
            Menu = (ArrayList<MenuEdit>) ois.readObject();
            for (MenuEdit list : Menu) {
                CdlistModel.addElement(list.OutputCD());
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading employees from file.");
        }

    }
}
