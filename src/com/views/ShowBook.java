package com.views;

import com.controller.AddBookController;
import com.controller.BorrowController;
import com.views.components.MainFrame;
import com.views.elementFactory.Label;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.jar.JarEntry;

public class ShowBook {
    public JPanel display(String title, String synopsis, String genre, String penulis ,String id){

        JPanel content = new JPanel();
        content.setBounds(300, 40, 1620, 1080);
        content.setBackground(Color.white);
        content.setLayout(null);

        ImageIcon cover = new ImageIcon(this.getClass().getResource("../public/image/default.png"));
        Image img = cover.getImage().getScaledInstance(350, 450, Image.SCALE_SMOOTH);
        ImageIcon cvr = new ImageIcon(img);
        JLabel coverDisplay = new JLabel();
        coverDisplay.setIcon(cvr);
        coverDisplay.setBounds(40, 40, 350, 450);

//        JTextArea tst = new JTextArea();
//        tst.isEditable();

        Label titleBook = new Label(440, 40, 25, 25, title);

        JLabel dateLabel = new JLabel("Tanggal Terbit : ");
        dateLabel.setBounds(440, titleBook.getY() + 35, 120, 15);
        dateLabel.setFont(new Font("Poppins", Font.PLAIN, 13));

        JLabel dateBook = new JLabel("12 Agustus 2020");
        dateBook.setBounds(550, titleBook.getY() + 35, 200, 15);
        dateBook.setFont(new Font("Poppins", Font.PLAIN, 13));

        Label synopsisLabel = new Label(440, dateBook.getY() + 60, 20, 20, "Synopsis");
//        JLabel synopsisBook = new JLabel(synopsis);

//        Label synopsisLabel = new Label(440, titleBook.getY() + 60, 16, 16, "Genre");
        JTextArea synopsisBook = new JTextArea(synopsis);
        synopsisBook.setBounds(440, synopsisLabel.getY() + 40, 300, 200);
        synopsisBook.setFont(new Font("Poppins", Font.PLAIN, 13));
        synopsisBook.setWrapStyleWord(true);
        synopsisBook.setLineWrap(true);
        synopsisBook.setEditable(false);

        JLabel genreLabel = new JLabel("Genre : ");
        genreLabel.setBounds(440, synopsisBook.getY() + 200, 70, 18);
        genreLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        JLabel genreBook = new JLabel(genre);
        genreBook.setBounds(510, synopsisBook.getY() + 200, 200, 18);
        genreBook.setFont(new Font("Poppins", Font.PLAIN, 14));

        JLabel penulisLabel = new JLabel("Penulis : ");
        penulisLabel.setBounds(440, genreLabel.getY() + 40, 70, 18);
        penulisLabel.setFont(new Font("Poppins", Font.PLAIN, 14));

        JLabel penulisBook = new JLabel(penulis);
        penulisBook.setBounds(510, genreLabel.getY() + 40, 200, 18);
        penulisBook.setFont(new Font("Poppins", Font.PLAIN, 14));

        JButton edit = new JButton("Edit");
        edit.setBounds(440, penulisBook.getY() + 60, 100, 30);
        edit.setFont(new Font("Poppins", Font.PLAIN, 14));
        edit.setBackground(Color.DARK_GRAY);
        edit.setForeground(Color.white);

        edit.addActionListener((event) -> {
            MainFrame.changeDisplay(AddBookController.edit(id));
        });

        content.add(edit);
        content.add(dateBook);
        content.add(dateLabel);
        content.add(genreBook);
        content.add(genreLabel);
        content.add(synopsisLabel);
        content.add(synopsisBook);
        content.add(titleBook);
        content.add(coverDisplay);
        content.add(penulisBook);
        content.add(penulisLabel);
        return content;
    }
}
