
package com.factory;
import java.util.LinkedList;
public class PengembalianMigration extends Migration{

    public static LinkedList<Field> fields = new LinkedList<>();


  PengembalianMigration (){
      super("Pengembalian", fields);
  }

  @Override
  public void tableBuilder() {
    //Create field
    Field id_peminjaman = new Field();
    //Name of field
    id_peminjaman.name = "id_peminjaman";
    //Type of field
    id_peminjaman.type = "int";
    //size of field
//    id_peminjaman.size = 255;
    //add field
    fields.add(id_peminjaman);

    Field id_peminjam = new Field();
    id_peminjam.name = "id_peminjam";
    id_peminjam.type = "int";
    fields.add(id_peminjam);

    Field id_buku = new Field();
    id_buku.name = "id_buku";
    id_buku.type = "int";
    fields.add(id_buku);

    Field tanggal_pengembalian = new Field();
    tanggal_pengembalian.name = "tanggal_pengembalian";
    tanggal_pengembalian.type = "date";
    fields.add(tanggal_pengembalian);

    //You can add another field
  }
}

