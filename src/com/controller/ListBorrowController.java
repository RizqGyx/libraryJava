package com.controller;

import com.models.Peminjaman;
import com.views.ListBorrow;
import com.views.PeminjamanBuku;

import javax.swing.*;
import java.sql.ResultSet;

public class ListBorrowController {
    static ListBorrow listBorrowView = new ListBorrow();
    public static JPanel display(){
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = peminjaman.getAll();
        return listBorrowView.display(rs);
    }
}
