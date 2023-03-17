
package com.factory;
import java.util.LinkedList;
public class PeminjamanMigration extends Migration{

    public static LinkedList<Field> fields = new LinkedList<>();


  PeminjamanMigration (){
      super("Peminjaman", fields);
  }

  @Override
  public void tableBuilder() {
    //Create field
    Field idPeminjam = new Field();
    //Name of field
    idPeminjam.name = "id_peminjam";
    //Type of field
    idPeminjam.type = "int";
    //size of field
    idPeminjam.size = 0;
    //add field
    fields.add(idPeminjam);

    Field idBuku = new Field();
    idBuku.name = "id_buku";
    idBuku.type = "int";
    idBuku.size = 0;
    fields.add(idBuku);

//    Field idAdmin = new Field();
//    idAdmin.name = "id_admin";
//    idAdmin.type = "int";
//    idAdmin.size = 0;
//    fields.add(idAdmin);

    Field tanggal_peminjaman = new Field();
    tanggal_peminjaman.name = "tanggal_peminjaman";
    tanggal_peminjaman.type = "date";
    fields.add(tanggal_peminjaman);
  }
}

