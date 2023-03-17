package com.views;

import com.views.elementFactory.ButtonEditor;
import com.views.elementFactory.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;


public class ListBorrow extends Canvas{
    public JPanel display(ResultSet rs) {

        JPanel content = new JPanel();
        content.setLayout(null);
        content.setBounds(300, 40, 1620, 1080);
        content.setBackground(Color.white);

        JLabel titlePage = new JLabel("List Peminjam");
        titlePage.setFont(new Font("Poppins Medium", Font.PLAIN, 30));
        titlePage.setBounds(40, 40, 400, 30);
        content.add(titlePage);

        String[] dataHeader = {"ID Transaksi", "ID Buku", "ID Peminjam", "Tanggal Peminjaman"};
        String[][] dataBook = {
        };

        DefaultTableModel data = new DefaultTableModel(dataBook,dataHeader);

        JTable listBooks = new JTable(data){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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
                data.addRow(new Object[]{rs.getString("id"), rs.getString("id_buku"),
                        rs.getString("id_peminjam"), rs.getString("tanggal_peminjaman")});
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        content.add(titlePage);
        content.add(scrollPane);
        return content;
    }
}