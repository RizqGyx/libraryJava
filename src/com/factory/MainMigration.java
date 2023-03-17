package com.factory;

import com.connect.ConnectConfig;

import java.sql.ResultSet;
import java.sql.Statement;

public class MainMigration {

    static Statement stmt;
    static ResultSet resultSet;

    public static void dropTable(){
        try {
            ConnectConfig.connect();
            stmt = ConnectConfig.conn.createStatement();
            resultSet = stmt.executeQuery("SHOW TABLES");
            while (resultSet.next()){
                stmt = ConnectConfig.conn.createStatement();
                stmt.executeUpdate("DROP TABLE " + resultSet.getString(1));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        dropTable();
        BookMigration book = new BookMigration();
        PeminjamanMigration peminjam = new PeminjamanMigration();
        PengembalianMigration pengembalian = new PengembalianMigration();
    }
}
