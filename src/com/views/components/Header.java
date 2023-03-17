package com.views.components;

import javax.swing.*;
import java.awt.*;

public class Header{
    public static JPanel display(){
        JPanel header = new JPanel();
        header.setBounds(299, 0, 1620, 40);
        header.setBackground(Color.BLUE);
        header.setLayout(null);
        return header;
    }
}
