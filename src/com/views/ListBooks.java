package com.views;

import com.views.elementFactory.ButtonEditor;
import com.views.elementFactory.ButtonRenderer;
import com.views.elementFactory.Label;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;

public class ListBooks{
    public JPanel display(ResultSet rs){
        int labelLocationY = 0;

        JPanel content = new JPanel();
        content.setLayout(null);
        content.setBounds(300, 40, 1620, 1080);
        content.setBackground(Color.white);

        JLabel titlePage = new JLabel("List Buku");
        titlePage.setFont(new Font("Poppins Medium", Font.PLAIN, 30));
        titlePage.setBounds(40, 40, 400, 30);
        content.add(titlePage);

        String[] dataHeader = {"Judul", "Penulis", "Genre", "Tanggal Terbit", "Stok", "Action"};
        String[][] dataBook = {
        };


        DefaultTableModel data = new DefaultTableModel(dataBook,dataHeader);

        JTable listBooks = new JTable(data);
        listBooks.getColumn("Action").setCellRenderer(new ButtonRenderer());
        listBooks.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
//        listBooks.isCellEditable(false);

        listBooks.setRowHeight(25);
        listBooks.setFont(new Font("Poppins", Font.PLAIN, 15));
        listBooks.setBorder(BorderFactory.createCompoundBorder(listBooks.getBorder(),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        listBooks.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(listBooks);
        scrollPane.setBounds(40, titlePage.getY() + 60, 1150, 600);
        scrollPane.setBackground(Color.white);

        try {
            while (rs.next()){
//                JButton detail = new JButton("Edit");
//                JLabel detail = new JLabel("Edit");
                data.addRow(new Object[]{rs.getString("name"), rs.getString("penulis"),
                rs.getString("genre"), rs.getString("tanggal_terbit"), rs.getString("stok"), rs.getInt("id")});
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        content.add(titlePage);
        content.add(scrollPane);
        return content;
    }
}
