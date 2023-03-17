package com.models;

import com.queryBuilder.QueryBuilder;
import com.factory.BookMigration;
import java.sql.ResultSet;
import java.util.Dictionary;
import java.util.Hashtable;


public class Books extends QueryBuilder {

    private static String model = "books";
    public String data = "";

    public Books(){
        super(model);
    }

}
