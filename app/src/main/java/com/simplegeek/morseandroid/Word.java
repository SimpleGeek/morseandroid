package com.simplegeek.morseandroid;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.simplegeek.morseandroid.signals.SignalController;

import java.util.Arrays;
import java.util.List;

public class Word {

    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void playWord(SignalController signalController) {
        letters.forEach(l -> l.executeSignal(signalController));
    }

    public void addSpaceBetweenWords() {
        Letter l = new Letter(Arrays.asList(Elements.WORD_SPACE));
        this.letters.add(l);
    }

}
