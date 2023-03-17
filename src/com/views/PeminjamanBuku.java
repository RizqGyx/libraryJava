package com.views;

import com.controller.AddBookController;
import com.controller.BorrowController;
import com.models.Peminjaman;
import com.toedter.calendar.JDateChooser;
import com.views.elementFactory.Label;
import com.views.elementFactory.TextField;
import com.views.rules.Format;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PeminjamanBuku implements Format{

    private int xAxisPengembalian = 550;
    private int xAxisPeminjaman = 40;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public JPanel display() {
        JPanel contain = new JPanel();
        contain.setBounds(300,40,1620, 1040);
        contain.setLayout(null);

        JLabel label = new JLabel("Peminjaman Buku");
        label.setBounds(30, 40, 400, 40);
        label.setFont(new Font("Poppins", Font.BOLD, 30));

        Label idBookPeminjaman = new Label(110, "ID Buku");
        TextField fIdBookPeminjaman = new TextField(145);

        Label idPeminjam = new Label(205, "ID Peminjam");
        TextField fIdPeminjam = new TextField(240);

        Label tanggalPeminjaman = new Label(300, "Tanggal Pinjam");
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        dateChooser.setBounds(30, 335, 200, 30);

        JButton daftarPinjam = new JButton("Pinjam");
        daftarPinjam.setBounds(30,395, 200, 50);
        daftarPinjam.setBackground(Color.DARK_GRAY);
        daftarPinjam.setForeground(Color.white);
        daftarPinjam.addActionListener((event) -> {
            int confirmation = JOptionPane.showConfirmDialog(null, "Yakin Ingin Meminjam Buku?",
                    "Book Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmation == 0){
                int code = BorrowController.setPeminjaman(fIdPeminjam.getText(), fIdBookPeminjaman.getText(), dateFormat.format(dateChooser.getDate()));
                if (code == 1){
                    JOptionPane.showMessageDialog(null, "Buku Tidak Ada");
                } else if (code == 2){
                    JOptionPane.showMessageDialog(null, "Stok Buku Kosong");
                }else{
                    fIdBookPeminjaman.setText("");
                    dateChooser.setDate(null);
                    fIdPeminjam.setText("");
                    JOptionPane.showMessageDialog(null, "Buku Dipinjam");
                }
            }
        });

        JLabel pengembalian = new JLabel("Pengembalian Buku");
        pengembalian.setBounds(xAxisPengembalian, 40, 400, 40);
        pengembalian.setFont(new Font("Poppins", Font.BOLD, 30));

        Label idPeminjaman = new Label(xAxisPengembalian,110, "ID Peminjaman");
        TextField fIdPeminjaman = new TextField(xAxisPengembalian, 145);

        Label idBookPengembalian = new Label(xAxisPengembalian,205, "ID Buku");
        TextField fIdBookPegembalian = new TextField(xAxisPengembalian, 240);

        Label idPengembali = new Label(xAxisPengembalian, 300, "ID Peminjam");
        TextField fIdPengembali = new TextField(xAxisPengembalian, 335);

        Label tanggalPengembalian = new Label(xAxisPengembalian, 395, "Tanggal Pinjam");
        JDateChooser dateChooserPengembalian = new JDateChooser();
        dateChooserPengembalian.setDate(new Date());
        dateChooserPengembalian.setBounds(xAxisPengembalian, 430, 200, 30);

        JButton pengembalianButton = new JButton("Kembalikan Buku");
        pengembalianButton.setBounds(xAxisPengembalian,480, 200, 50);
        pengembalianButton.setBackground(Color.DARK_GRAY);
        pengembalianButton.setForeground(Color.white);

        pengembalianButton.addActionListener((event)->{
            int confirmation = JOptionPane.showConfirmDialog(null, "Yakin Ingin Mengembalikan Buku?",
                    "Book Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            System.out.println(dateFormat.format(dateChooserPengembalian.getDate()));
            if(confirmation == 0){
                int code = BorrowController.setPengembalian(fIdPeminjaman.getText(), fIdPengembali.getText(), fIdBookPegembalian.getText(), dateFormat.format(dateChooserPengembalian.getDate()));
                if (code == 1){
                    JOptionPane.showMessageDialog(null, "Id Peminjaman Tidak Ditemukan");
                } else if (code == 2){
                    JOptionPane.showMessageDialog(null, "Id Peminjam Tidak Sesuai");
                }else if(code == 3){
                    JOptionPane.showMessageDialog(null, "Id Buku tidak Sesuai");
                }else{
                    fIdBookPegembalian.setText("");
                    dateChooserPengembalian.setDate(null);
                    fIdPengembali.setText("");
                    fIdPeminjaman.setText("");
                    JOptionPane.showMessageDialog(null, "Buku Dikembalikan");
                }
            }
        });

        contain.add(idPeminjaman);
        contain.add(fIdPeminjaman);
        contain.add(idBookPeminjaman);
        contain.add(fIdBookPeminjaman);
        contain.add(label);
        contain.add(tanggalPeminjaman);
        contain.add(idPeminjam);
        contain.add(fIdPeminjam);
        contain.add(tanggalPeminjaman);
        contain.add(dateChooser);
        contain.add(idBookPengembalian);
        contain.add(fIdBookPegembalian);
        contain.add(tanggalPengembalian);
        contain.add(dateChooserPengembalian);
        contain.add(idPengembali);
        contain.add(fIdPengembali);
        contain.add(pengembalianButton);
        contain.add(daftarPinjam);
        contain.add(pengembalian);

        return contain;
    }


}