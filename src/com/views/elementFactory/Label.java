package com.views.elementFactory;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class Label extends JLabel {
    public Label(int y, String text){
        setText(text);
        setBounds(30, y, 400, 30);
        setFont(new Font("Poppins", Font.PLAIN, 20));
    }

//    public Label(int y, int height, int size, String text){
//        setText(text);
//        setBounds(30, y, 400, height);
//        setFont(new Font("Poppins Medium", Font.PLAIN, size));
//    }

    public Label(int x, int y, int size, String text){
        setText(text);
        setBounds(x, y, 400, size);
        setFont(new Font("Poppins", Font.PLAIN, size));
    }

    public Label(int x, int y, int height, int size, String text){
        setText(text);
        setBounds(x, y, 400, height);
        setFont(new Font("Poppins Medium", Font.PLAIN, size));
    }

    public Label(int x, int y, String text){
        setText(text);
        setBounds( x, y, 400, 30);
        setFont(new Font("Poppins", Font.PLAIN, 20));
    }
}
