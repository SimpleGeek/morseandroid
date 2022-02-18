package com.simplegeek.morseandroid.parser;

import com.simplegeek.morseandroid.Letter;
import com.simplegeek.morseandroid.Letters;

import java.util.HashMap;
import java.util.Map;

public class MorseMap {

    private static Map<Character, Letter> m = new HashMap<>();

    // Initialize all the characters statically
    static {
        m.put('A', Letters.A);
        m.put('B', Letters.B);
        m.put('C', Letters.C);
        m.put('D', Letters.D);
        m.put('E', Letters.E);
        m.put('F', Letters.F);
        m.put('G', Letters.G);
        m.put('H', Letters.H);
        m.put('I', Letters.I);
        m.put('J', Letters.J);
        m.put('K', Letters.K);
        m.put('L', Letters.L);
        m.put('M', Letters.M);
        m.put('N', Letters.N);
        m.put('O', Letters.O);
        m.put('P', Letters.P);
        m.put('Q', Letters.Q);
        m.put('R', Letters.R);
        m.put('S', Letters.S);
        m.put('T', Letters.T);
        m.put('U', Letters.U);
        m.put('V', Letters.V);
        m.put('W', Letters.W);
        m.put('X', Letters.X);
        m.put('Y', Letters.Y);
        m.put('Z', Letters.Z);
    }

    public static Letter get(Character c) {
        return m.get(c);
    }

}
