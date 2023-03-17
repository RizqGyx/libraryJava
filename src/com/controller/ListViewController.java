package com.controller;
import com.models.Books;
import com.views.ListBooks;

import javax.swing.*;
import java.sql.ResultSet;

public class ListViewController {
        static Books books = new Books();
        static ListBooks listBookView = new ListBooks();
        public static JPanel display(){
            ResultSet rs = books.getAll();
            return listBookView.display(rs);
        }
}
