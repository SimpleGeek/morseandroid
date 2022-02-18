package com.simplegeek.morseandroid;

import java.util.Arrays;

// Static imports for brevity's sake
import static com.simplegeek.morseandroid.Elements.DASH;
import static com.simplegeek.morseandroid.Elements.DOT;

/**
 * This class contains constant Letter objects built out
 * to represent each letter in the alphabet.
 */
public class Letters {

    public static Letter A = Letter.buildWithSpaces(Arrays.asList(DOT, DASH));
    public static Letter B = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DOT, DOT));
    public static Letter C = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DASH, DOT));
    public static Letter D = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DOT));
    public static Letter E = Letter.buildWithSpaces(Arrays.asList(DOT));
    public static Letter F = Letter.buildWithSpaces(Arrays.asList(DOT, DOT, DASH, DOT));
    public static Letter G = Letter.buildWithSpaces(Arrays.asList(DASH, DASH, DOT));
    public static Letter H = Letter.buildWithSpaces(Arrays.asList(DOT, DOT, DOT, DOT));
    public static Letter I = Letter.buildWithSpaces(Arrays.asList(DOT, DOT));
    public static Letter J = Letter.buildWithSpaces(Arrays.asList(DOT, DASH, DASH, DASH));
    public static Letter K = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DASH));
    public static Letter L = Letter.buildWithSpaces(Arrays.asList(DOT, DASH, DOT, DOT));
    public static Letter M = Letter.buildWithSpaces(Arrays.asList(DASH, DASH));
    public static Letter N = Letter.buildWithSpaces(Arrays.asList(DASH, DOT));
    public static Letter O = Letter.buildWithSpaces(Arrays.asList(DASH, DASH, DASH));
    public static Letter P = Letter.buildWithSpaces(Arrays.asList(DOT, DASH, DASH, DOT));
    public static Letter Q = Letter.buildWithSpaces(Arrays.asList(DASH, DASH, DOT, DASH));
    public static Letter R = Letter.buildWithSpaces(Arrays.asList(DOT, DASH, DOT));
    public static Letter S = Letter.buildWithSpaces(Arrays.asList(DOT, DOT, DOT));
    public static Letter T = Letter.buildWithSpaces(Arrays.asList(DASH));
    public static Letter U = Letter.buildWithSpaces(Arrays.asList(DOT, DOT, DASH));
    public static Letter V = Letter.buildWithSpaces(Arrays.asList(DOT, DOT, DOT, DASH));
    public static Letter W = Letter.buildWithSpaces(Arrays.asList(DOT, DASH, DASH));
    public static Letter X = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DOT, DASH));
    public static Letter Y = Letter.buildWithSpaces(Arrays.asList(DASH, DOT, DASH, DASH));
    public static Letter Z = Letter.buildWithSpaces(Arrays.asList(DASH, DASH, DOT, DOT));

}
