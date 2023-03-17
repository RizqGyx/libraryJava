package com.views.components;
import com.controller.AddBookController;
import com.controller.BorrowController;
import com.controller.ListBorrowController;
import com.controller.ListViewController;
import com.models.Books;
import com.views.AddBook;
import com.views.ListBooks;
import com.views.ListBorrow;
import com.views.PeminjamanBuku;
import com.views.elementFactory.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

public class Sidebar{

    public JPanel display(){
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 300, 1080);
        panel.setBackground(new Color(47,47,47));
        panel.setLayout(null);

//        AddBookController ab = new AddBookController();
        MenuButton addBookMenu = new MenuButton(40, "Tambah Buku", AddBookController.display());
        MenuButton listBookMenu = new MenuButton(80, "List Buku", ListViewController.display());
        MenuButton pinjamBook = new MenuButton(120, "Peminjaman Buku", BorrowController.display());
        MenuButton ListPinjamBook = new MenuButton(160, "List Pinjam", ListBorrowController.display());

        panel.add(addBookMenu);
        panel.add(listBookMenu);
        panel.add(pinjamBook);
        panel.add(ListPinjamBook);
        return panel;
    }

}
