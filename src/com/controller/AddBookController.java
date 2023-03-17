package com.controller;

import com.models.Books;
import com.views.AddBook;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
//import javafx.*;

public class AddBookController {
    static AddBook view = new AddBook();
    static private String title;
    static private String penulis;
    static private String synopsis;
    static private String genre;
    static private String tanggal;
    static private String stok;

    public static JPanel display(){
        return view.display();
    }

    public static JPanel edit(String id){
        Books book = new Books();
        try {
            ResultSet rs = book.getItem(id);
            if (rs.next()){
                title = rs.getString("name");
                penulis = rs.getString("penulis");
                synopsis = rs.getString("synopsis");
                genre = rs.getString("genre");
                stok =  rs.getString("stok");
                tanggal = rs.getString("tanggal_terbit");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return view.display(title, synopsis, penulis, genre, tanggal, stok, id);
    }


    public static void setNewBook(String title, String synopsis, String penulis, String tanggal_terbit, String genre, String stok){
        Books newBook = new Books();
        newBook.values.put("name", title);
        newBook.values.put("synopsis", synopsis);
        newBook.values.put("penulis", penulis);
        newBook.values.put("tanggal_terbit", tanggal_terbit);
        newBook.values.put("genre", genre);
        newBook.values.put("stok", stok);

        newBook.add();
    }

    public static void editBook(String title, String synopsis, String penulis, String tanggal_terbit, String genre, String stok, String id){
        Books books = new Books();
        String query = "UPDATE books SET name = '" + title + "' , synopsis = '" + synopsis + "' , penulis = '" + penulis +
                "', genre = '" + genre + "' , stok=" + stok + ", tanggal_terbit = '" + tanggal_terbit + "' WHERE id = " + id + " ;";
        books.query(query);
    }

    public static void joinBook(){
        Books book = new Books();
//        book.query("SELECT * FROM BOOK JOIN")
    }

}
