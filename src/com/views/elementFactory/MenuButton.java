package com.views.elementFactory;

import com.views.components.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JLabel {
    public MenuButton(int y, String text, JPanel content){
        setText(text);
        setBounds(40, y, 200, 20);
        setFont(new Font("Poppins Medium", Font.PLAIN, 18));
        setForeground(Color.WHITE);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.changeDisplay(content);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

}
