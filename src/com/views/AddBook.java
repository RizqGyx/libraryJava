package com.views;

import com.controller.AddBookController;
import com.toedter.calendar.JDateChooser;
import com.views.components.MainFrame;
import com.views.elementFactory.Label;
import com.views.elementFactory.TextField;
import com.views.rules.Genre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.PushbackInputStream;
import java.security.PublicKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AddBook implements Genre {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    List<String> gnr = new ArrayList<>();

    public JPanel display(){
        return display("", "", "", "", "", "", "");
    }

    public JPanel display(String tBook, String sBook, String pBook, String gBook, String tgBook, String stBook, String id){
        JLabel coverDisplay = new JLabel();

        JPanel content = new JPanel();
        content.setBounds(300, 40, 1620, 1080);
        content.setBackground(Color.white);
        content.setLayout(null);

        //Title Page
        JLabel label = new JLabel("Tambah Buku Baru");
        if (!tBook.isEmpty()){
            label.setText("Edit Buku");
        }
        label.setBounds(30, 30, 400, 40);
        label.setFont(new Font("Poppins Medium", Font.BOLD, 30));

        //Untuk Judul Buku
        Label bookTitle = new Label(100, "Judul Buku");
//        bookTitle.setText(tBook);
        TextField fBookTitle = new TextField(145);
        fBookTitle.setText(tBook);

        //Untuk sinopsis Buku
        Label bookSynopsis = new Label(210, "Masukkan Sinopsis Buku");

        JTextArea fSynopsis = new JTextArea();
        fSynopsis.setText(sBook);
        JScrollPane synopsis = new JScrollPane(fSynopsis);

        fSynopsis.setLineWrap(true);
        fSynopsis.setWrapStyleWord(true);
        fSynopsis.setFont(new Font("Poppins", Font.PLAIN, 14));

        synopsis.setBounds(30, bookSynopsis.getY()+40, 400, 200 );
        fSynopsis.setBounds(30, bookSynopsis.getY()+40, 400, 200 );
        synopsis.setViewportView(fSynopsis);

        fSynopsis.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Untuk Nama Penulis
        Label penulis = new Label(synopsis.getY()+240, "Penulis Buku");
        TextField fPenulis = new TextField(penulis.getY() + 40);
        fPenulis.setText(pBook);

        //Untuk Tanggal
        Label date = new Label(fPenulis.getY() + 60, "Tanggal Penerbitan Buku");

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(30, date.getY() + 40, 200, 30);
        if (!tgBook.isEmpty()){
            try {
                Date tmp = dateFormat.parse(tgBook);
                dateChooser.setDate(tmp);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //Untuk Tombol Kirim
        JButton newBook = new JButton("Tambah Buku");
        if (!tBook.isEmpty()){
            newBook.setText("Edit Buku");
        }
        newBook.setBounds(30, dateChooser.getY() + 60, 200, 50);
        newBook.setBackground(Color.DARK_GRAY);
        newBook.setForeground(Color.white);
        newBook.setFont(new Font("Poppins", Font.PLAIN, 14));

        //Untuk upload gambar
        JButton uploadImage = new JButton("Upload Image");
        uploadImage.setBackground(Color.darkGray);
        uploadImage.setForeground(Color.white);
        uploadImage.setFont(new Font("Poppins", Font.PLAIN, 13));
        uploadImage.setBounds(480, 450, 130, 40);


        uploadImage.addActionListener((event) -> {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            try {
                File f = chooser.getSelectedFile();
                ImageIcon imgCover = new ImageIcon(f.toString());
                Image img = imgCover.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
                ImageIcon imgCover2 = new ImageIcon(img);
                coverDisplay.setIcon(imgCover2);
            } catch (NullPointerException error){
                error.printStackTrace();
            }
        });

        ImageIcon cover = new ImageIcon(this.getClass().getResource("../public/image/default.png"));
        Image img = cover.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        ImageIcon cvr = new ImageIcon(img);
        coverDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        coverDisplay.setIcon(cvr);
        coverDisplay.setBounds(480, 40, 300, 400);


        Label genreTitle = new Label(480, uploadImage.getY() + 50, "Genre");

        JComboBox<String> genre = new JComboBox<>(Genre.genre);
        genre.setBounds(480, genreTitle.getY() + 40, 300, 30);
        genre.setFont(new Font("Poppins", Font.PLAIN, 15));
        genre.setSelectedItem(null);

//        JButton addGenre = new JButton("+");
//        addGenre.setBounds(800, genreTitle.getY() + 50, 30, 30);

        if (!gBook.isEmpty()){
            genre.setSelectedItem(gBook);
        }

        //Stok
        Label stokTitle = new Label(480, genre.getY() + 60, "Stok");
        TextField stok = new TextField(480, stokTitle.getY() + 40);
        stok.setText(stBook);


        if (!gBook.isEmpty()){
            newBook.addActionListener((event) -> {
                int confirmation = JOptionPane.showConfirmDialog(null, "Yakin Ingin Merubah Buku ?",
                        "Book Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(confirmation == 0){
                    AddBookController.editBook(fBookTitle.getText(), fSynopsis.getText(), fPenulis.getText(),
                            dateFormat.format(dateChooser.getDate()),
                            (String) genre.getSelectedItem(), stok.getText(), id);
                }
            });

        }else{
            newBook.addActionListener(new SubmitBook(fPenulis, dateChooser, fBookTitle, fSynopsis, genre, stok));
        }

//        content.add(addGenre);
        content.add(genre);
        content.add(stokTitle);
        content.add(stok);
//        content.add(genres);
        content.add(genreTitle);
        content.add(date);
        content.add(dateChooser);
        content.add(penulis);
        content.add(fPenulis);
        content.add(synopsis);
        content.add(uploadImage);
        content.add(coverDisplay);
        content.add(bookSynopsis);
        content.add(fBookTitle);
        content.add(bookTitle);
        content.add(label);
        content.add(newBook);

        return content;
    }


    class SubmitBook implements ActionListener{
        TextField fPenulis;
        JDateChooser dateChooser;
        TextField fBookTitle;
        JTextArea fSynopsis;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JComboBox<String> genre;
        JTextField stok;


        SubmitBook(TextField fPenulis, JDateChooser dateChooser, TextField fBookTitle, JTextArea fSynopsis, JComboBox<String> genre,
                   JTextField stok){
            this.fPenulis = fPenulis;
            this.dateChooser = dateChooser;
            this.fBookTitle = fBookTitle;
            this.fSynopsis = fSynopsis;
            this.genre = genre;
            this.stok = stok;
        }

        public void actionPerformed(ActionEvent e) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Yakin Ingin Menambah Buku ?",
                    "Book Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmation == 0){
                AddBookController.setNewBook(fBookTitle.getText(), fSynopsis.getText(), fPenulis.getText(), dateFormat.format(dateChooser.getDate()),
                        (String) genre.getSelectedItem(), stok.getText());
                fPenulis.setText("");
                dateChooser.setDate(null);
                fBookTitle.setText("");
                fSynopsis.setText("");
                stok.setText("");
                genre.setSelectedItem(null);

                JOptionPane.showMessageDialog(null, "Buku Sudah Tersimpan");
            }
        }
    }

}
