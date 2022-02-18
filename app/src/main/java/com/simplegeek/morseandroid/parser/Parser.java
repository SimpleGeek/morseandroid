package com.simplegeek.morseandroid.parser;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.simplegeek.morseandroid.Letter;
import com.simplegeek.morseandroid.Word;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Word> getMessage(String text) {
        List<Word> message = new LinkedList<>();
        String[] textWords = text.split("\\s+");
        for (int i = 0; i < textWords.length; i++) {
            String textWord = textWords[i];
            Word w = parseTextToWord(textWord);
            if (w != null) {
                if (i < (textWords.length - 1)) {
                    // Add a space to the end of the word if
                    // this is not the last word in the message.
                    w.addSpaceBetweenWords();
                }

                // Only add non-null words.  Null words would be
                // returned in cases where there was a single character
                // by itself that couldn't be parsed into an element.
                // This would be things like special characters, e.g., $, %, ^, etc.
                message.add(w);
            }
        }
        return message;
    }

    private Word parseTextToWord(String textWord) {
        List<Letter> letters = new ArrayList<>();
        char[] chars = textWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            c = Character.toUpperCase(c);

            if (!Character.isLetter(c)) {
                // Skip to the next character, if this is not
                // a character.  Currently, we don't support
                // anything other than regular characters.
                continue;
            }

            try {
                Letter l = MorseMap.get(c);
                if (i < (chars.length - 1)) {
                    // Add the space that occurs between letters
                    // to the end of the letter, unless the letter
                    // is the last letter in the word.
                    l.addSpaceBetweenLetters();
                }
                letters.add(l);
            } catch (Exception e) {
                // Something went wrong at some point while
                // getting the letter object, so just carry
                // on to the next letter.
            }
        }
        return new Word(letters);
    }

}
