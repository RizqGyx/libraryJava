package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectConfig {
    private static final String JDBC = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/perpustakaan";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conn;

    public static void connect(){
        try {
            Class.forName(JDBC);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
