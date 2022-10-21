package com.sonny.demo.ShowAvailableFonts;

import com.itextpdf.text.FontFactory;

import java.awt.*;

public class ShowFontsDemo {

    public static void main(String[] args) {

        GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = gEnvironment.getAllFonts();

        int index = 1;
        for (Font font: fonts) {
            System.out.printf(
                    "%d. Font Family=%s, Font Name=%s \n",
                    index,
                    font.getFamily(),
                    font.getFontName());

            index++;
        }

    }
}
