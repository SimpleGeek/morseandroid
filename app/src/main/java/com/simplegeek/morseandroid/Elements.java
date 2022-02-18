package com.simplegeek.morseandroid;

public class Elements {

    private static final double BASE_VALUE = 0.25;

    // A dash "-"
    public static final Element DASH = new Element(3, true, false);
    // A dot "."
    public static final Element DOT = new Element(1, true, false);
    // The pause that occurs between the individual dashes and dots that comprise a character
    public static final Element CHAR_UNIT_SPACE = new Element(1);
    // The pause that occurs between individual letters within a word
    public static final Element LETTER_SPACE = new Element(3);
    // The pause that occurs between words
    public static final Element WORD_SPACE = new Element(7);

}
