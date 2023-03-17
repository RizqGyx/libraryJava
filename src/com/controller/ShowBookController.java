package com.controller;

import com.models.Books;
import com.views.ShowBook;

import javax.swing.*;
import java.sql.ResultSet;

public class ShowBookController {
    static String title;
    static String synopsis;
    static String genre;
    static String penulis;
//    static String idBuku;

    public static JPanel display(String id){
        Books book = new Books();
        ResultSet rs = book.getItem(id);
        ShowBook view = new ShowBook();
        try {
            if (rs.next()){
                title = rs.getString("name");
                synopsis = rs.getString("synopsis");
                genre = rs.getString("genre");
                penulis = rs.getString("penulis");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return view.display(title, synopsis, genre, penulis,id);
    }

}
