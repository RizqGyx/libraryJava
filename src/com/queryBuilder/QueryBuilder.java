package com.queryBuilder;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.connect.ConnectConfig;
import com.factory.Field;
import com.factory.Migration;

public abstract class QueryBuilder{

    private static Statement stmt;
    private ResultSet rs;
    private String model;
    public Hashtable<String, String> values = new Hashtable<>();
//    public Hashtable<String, String> values = new Hashtable<>();
    private Vector<String> fieldList = new Vector<>();


    public QueryBuilder(String model){
        ConnectConfig.connect();
        try {
            stmt = ConnectConfig.conn.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.model = model;
        defineField();
    }

    public ResultSet getAll( ){
        try {
            String query = "SELECT * FROM " + model;
            rs = stmt.executeQuery(query);
        }catch (Exception e){
            e.getStackTrace();
        }
        return rs;
    }

    public ResultSet getItem(String id){
        try {
            String query = "SELECT * FROM " + model + " WHERE ID = " + id;
            rs = stmt.executeQuery(query);
//            System.out.println(rs.getString("name"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public void deleteById(String id){
        try {
            String query = "DELETE FROM " + model + " WHERE id = " + id + " ;";
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(){

        String query = "INSERT INTO " + model + " ( ";
        String query2 = "VALUE (";

        for (int i = 1 ; i < fieldList.size() ; i++){
            String koma = "";
            if (i != fieldList.size() - 1){
                koma = ", ";
            }
            query += fieldList.get(i) + koma;
            query2 += " '" + values.get(fieldList.get(i)) + "' " + koma;
        }

        String finalQuery = query + " ) " + query2 + " ); ";
//        System.out.println(finalQuery);

        try{
            stmt = ConnectConfig.conn.createStatement();
            stmt.executeUpdate(finalQuery);
            System.out.println("Berhasil tambah data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet query(String query){
        try {
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public void defineField(){
        try {
            rs = stmt.executeQuery("DESC " + model);
            while (rs.next()){
                fieldList.add(rs.getString(1));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
