package com.seeder;
import com.models.Books;

public class BookSeeder {
    public static void main(String[] args) {
        Books book = new Books();
        book.values.put("name", "Ada apa dengan dia");
        book.values.put("penulis", "Gymnas");
        book.values.put("synopsis", "Pernahkah kamu memikirkan apa yang sedang dia pikirkan?");
        book.values.put("tanggal_terbit", "2002-11-29");
        book.values.put("genre", "Romance");
        book.add();

        book.values.put("name", "Dia Milikku");
        book.values.put("synopsis", "Dia adalah milikku dan akan selalu menjadi milikki");
        book.values.put("penulis", "Gymnas");
        book.values.put("tanggal_terbit", "2022-11-29");
        book.values.put("genre", "romance");
        book.add();
    }
}
