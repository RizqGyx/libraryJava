package com.controller;

import com.models.Books;
import com.models.Peminjaman;
import com.models.Pengembalian;
import com.views.PeminjamanBuku;

import javax.swing.*;
import java.sql.ResultSet;

public class BorrowController {
    static PeminjamanBuku borrowBookView = new PeminjamanBuku();
    public static JPanel display(){
        return borrowBookView.display();
    }

    public static int setPeminjaman(String id_peminjam, String id_buku, String tanggal_peminjaman){

        Books book = new Books();
        ResultSet rs = book.getItem(id_buku);

        try {
            if(!rs.next()){
                return 1;
            }
            if(rs.getInt("stok") == 0){
                return 2;
            }
            String query = "UPDATE books SET stok = " + (rs.getInt("stok") - 1) + " WHERE id = " + id_buku + " ;";
            book.query(query);
            Peminjaman peminjaman = new Peminjaman();
            peminjaman.values.put("id_buku", id_buku);
            peminjaman.values.put("id_peminjam", id_peminjam);
            peminjaman.values.put("tanggal_peminjaman", tanggal_peminjaman);
            peminjaman.add();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static int setPengembalian(String id_peminjaman, String id_peminjam, String id_buku, String tanggal_kembali){

        Books book = new Books();
        ResultSet bookChoosed = book.getItem(id_buku);
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = peminjaman.getItem(id_peminjaman);
        Pengembalian pengembalian = new Pengembalian();

        try {
            if(!rs.next()){
                return 1;
            }

            if (rs.getInt("id_peminjam") != Integer.parseInt(id_peminjam)){
                return 2;
            }

            if (rs.getInt("id_buku") != Integer.parseInt(id_buku)){
                return 3;
            }
            if(bookChoosed.next()){
                String query = "UPDATE books SET stok = " + (bookChoosed.getInt("stok") + 1) + " WHERE id = " + id_buku + " ;";
                book.query(query);
            }

            peminjaman.deleteById(id_peminjaman);
            pengembalian.values.put("id_peminjaman", id_peminjaman);
            pengembalian.values.put("id_peminjam", id_peminjam);
            pengembalian.values.put("id_buku", id_buku);
            pengembalian.values.put("tanggal_pengembalian", tanggal_kembali);
            pengembalian.add();

        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }
}
