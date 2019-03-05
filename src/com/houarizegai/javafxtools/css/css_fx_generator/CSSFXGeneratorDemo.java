package com.houarizegai.javafxtools.css.css_fx_generator;

public class CSSFXGeneratorDemo {
    public static void main(String[] args) {
        String style = new CSSFXGenerator()
                .setFontFamily("Arial", "Tahoma", "Comic Sans MS")
                .setFontSize(24)
                .setFontWeight("bold")
                .setBackgroundColor("#2196f3")
                .setBackgroundRadius(10)
                .setFill("#FFF")
                .setTextFill("RED")
                .build();

        System.out.println(style);
    }
}
