package com.factory;


import java.util.LinkedList;

public class BookMigration extends Migration{

    private static LinkedList<Field> fields = new LinkedList<>();

    BookMigration(){
        super("Books", fields);
    }

    @Override
    public void tableBuilder() {
        super.test = "La";
        Field bookName = new Field();
        bookName.name = "name";
        bookName.type = "varchar";
        bookName.size = 255;
        fields.addLast(bookName);

        Field bookGenre = new Field();
        bookGenre.name = "synopsis";
        bookGenre.type = "text";
//        bookGenre.size = 255;
        fields.addLast(bookGenre);

        Field penulis = new Field();
        penulis.name = "penulis";
        penulis.type = "varchar";
        penulis.size = 255;
        fields.addLast(penulis);

        Field tanggal_terbit = new Field();
        tanggal_terbit.name = "tanggal_terbit";
        tanggal_terbit.type = "date";
        fields.addLast(tanggal_terbit);

        Field stok = new Field();
        stok.name = "stok";
        stok.type = "int";
        stok.size = 0;
        fields.addLast(stok);

        Field genre = new Field();
        genre.name = "genre";
        genre.type = "varchar";
        genre.size = 255;
        fields.add(genre);
    }
}
