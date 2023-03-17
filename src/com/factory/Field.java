package com.factory;

public class Field {
    protected String name;
    protected String type;
    protected int size;

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
}
