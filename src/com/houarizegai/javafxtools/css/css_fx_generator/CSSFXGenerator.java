package com.houarizegai.javafxtools.css.css_fx_generator;

public class CSSFXGenerator {
    private StringBuilder styleBuilder;

    public CSSFXGenerator() {
        styleBuilder = new StringBuilder();
    }

    public CSSFXGenerator add(String tag, String value) {
        styleBuilder.append(tag).append(": ").append(value).append(";");
        return this;
    }

    public CSSFXGenerator add(String tag, double value) {
        styleBuilder.append(tag).append(": ").append(value).append(";");
        return this;
    }

    public CSSFXGenerator add(String tag, int value) {
        styleBuilder.append(tag).append(": ").append(value).append(";");
        return this;
    }

    /* Start Font style */

    public CSSFXGenerator setFontSize(double size) {
        add("-fx-font-size", size + "px");
        return this;
    }

    public CSSFXGenerator setFontFamily(String... font) {
        if(font.length == 0)
            return this;

        styleBuilder.append("-fx-font-family: ");
        for(int i = 0; i < font.length; i++) {
            if(font[i].trim().contains(" "))
                styleBuilder.append("\"").append(font[i]).append("\"");
            else
                styleBuilder.append(font[i]);
            styleBuilder.append(", ");
        }
        if(styleBuilder.toString().endsWith(", ")) {
            styleBuilder.delete(styleBuilder.length() - 2, styleBuilder.length());
        }
        styleBuilder.append(";");
        return this;
    }

    public CSSFXGenerator setFontWeight(String weight) {
        add("-fx-font-weight", weight);
        return this;
    }

    public CSSFXGenerator setCursor(String cursorType) {
        add("-fx-cursor", cursorType);
        return this;
    }

    /* End Font style */

    /* Start Text Style */

    public CSSFXGenerator setTextFill(String color) {
        add("-fx-text-fill", color);
        return this;
    }

    public CSSFXGenerator setFill(String color) {
        add("-fx-fill", color);
        return this;
    }

    /* End Text Style */

    /* Start Background Style */

    public CSSFXGenerator setBackgroundColor(String color) {
        add("-fx-background-color", color);
        return this;
    }

    public CSSFXGenerator setBackgroundRadius(double radius) {
        add("-fx-background-radius", radius);
        return this;
    }

    /* End Background Style */

    public String build() {
        return styleBuilder.toString();
    }

}
