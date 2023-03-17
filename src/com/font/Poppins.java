package com.font;

import java.awt.*;
import java.io.File;

public class Poppins {

    public static Font poppins;
    public static Font poppinsBold;
    public static Font poppinsRegular;

    public Poppins(){
        try {
            poppinsBold = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Bold.ttf")).deriveFont(20f);
            poppins = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Medium.ttf")).deriveFont(30f);
            poppinsRegular = Font.createFont(Font.TRUETYPE_FONT, new File("Poppins-Regular.ttf")).deriveFont(20f);


            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);
            ge.registerFont(poppinsBold);
            ge.registerFont(poppinsRegular);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
