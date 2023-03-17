package com.views.components;

import com.controller.AddBookController;
import com.font.Poppins;
import com.views.AddBook;

import javax.swing.*;

public class MainFrame extends JFrame{
    static JFrame frame = new JFrame();
    static JPanel content;
    static Sidebar sb= new Sidebar();

    public static void display (String title){
        frame.setTitle(title);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(Header.display());
        frame.getContentPane().add(sb.display());
        AddBookController ab = new AddBookController();
        frame.getContentPane().add(ab.display());
        frame.setVisible(true);
        Poppins poppins = new Poppins();

    }

    public static void changeDisplay(JPanel destPanel){
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.getContentPane().add(Header.display());
        frame.getContentPane().add(sb.display());
        frame.getContentPane().add(destPanel);
        frame.repaint();
        frame.revalidate();
    }

    public static void refresh(){
        frame.repaint();
        frame.revalidate();
    }
}
