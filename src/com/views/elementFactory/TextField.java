package com.views.elementFactory;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField{
    public TextField(int y){
        setBounds(30, y, 400, 33);
        setFont(new Font("Poppins", Font.PLAIN, 14));
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(3, 5, 3, 5)));
    }

    public TextField(int x, int y){
        setBounds(x, y, 400, 33);
        setFont(new Font("Poppins", Font.PLAIN, 14));
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(3, 5, 3, 5)));
    }
}
