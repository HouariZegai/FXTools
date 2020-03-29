package com.houarizegai.fxtools.custom.css.fxcssgenerator;

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

    public CSSFXGenerator add(String tag, boolean value) {
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

    public CSSFXGenerator setFontStyle(String style) {
        add("-fx-font-style", style);
        return this;
    }

    /* End Font style */

    /* Start Text Style */

    public CSSFXGenerator setTextFill(String color) {
        add("-fx-text-fill", color);
        return this;
    }

    public CSSFXGenerator setPromptTextFill(String color) {
        add("-fx-prompt-text-fill", color);
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

    /* Start Border Style */

    public CSSFXGenerator setBorder(String width, String style, String color) {
        add("-fx-border", new StringBuilder()
                .append(width).append(" ")
                .append(style).append(" ")
                .append(color).toString());
        return this;
    }

    public CSSFXGenerator setBorderStyle(String style) {
        add("-fx-border-style", style);
        return this;
    }

    public CSSFXGenerator setBorderColor(String color) {
        add("-fx-border-color", color);
        return this;
    }

    public CSSFXGenerator setBorderwidth(String width) {
        add("-fx-border-width", width);
        return this;
    }

    /* End Border Style */

    /* Start Padding Style */

    public CSSFXGenerator setPadding(String padding) {
        add("-fx-padding", padding);
        return this;
    }

    public CSSFXGenerator setPadding(String top,String right, String bottom, String left) {
        add("-fx-padding", new StringBuilder()
                .append(top).append(" ")
                .append(right).append(" ")
                .append(bottom).append(" ")
                .append(left).toString());
        return this;
    }

    /* End Padding Style */

    /* Start Padding Style */

    public CSSFXGenerator setMargin(String margin) {
        add("-fx-margin", margin);
        return this;
    }

    public CSSFXGenerator setMargin(String top,String right, String bottom, String left) {
        add("-fx-margin", new StringBuilder()
                .append(top).append(" ")
                .append(right).append(" ")
                .append(bottom).append(" ")
                .append(left).toString());
        return this;
    }

    /* End Padding Style */

    /* Start Other */

    public CSSFXGenerator setOpacity(double opacity) {
        add("-fx-opacity", opacity);
        return this;
    }

    public CSSFXGenerator setUnderline(boolean underline) {
        add("-fx-underline", underline);
        return this;
    }

    public CSSFXGenerator setCursor(String cursorType) {
        add("-fx-cursor", cursorType);
        return this;
    }

    /* End Other */

    public String build() {
        return styleBuilder.toString();
    }

}
