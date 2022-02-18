package com.simplegeek.morseandroid;

import android.os.Build;
import android.os.SystemClock;

import androidx.annotation.RequiresApi;

import com.simplegeek.morseandroid.signals.SignalController;
import com.simplegeek.morseandroid.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Letter {

    private List<Element> elements;

    /**
     * This method takes a list of elements without spaces
     * (i.e., just the dashes or dots that comprise a single
     * character), and then builds out the letter while filling
     * in the spaces between characters.  This makes static initialization
     * of letters much less verbose.
     *
     * @param elements
     */
    public static Letter buildWithSpaces(List<Element> elements) {
        List<Element> elementsWithSpaces = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            Element e = elements.get(i);
            if (!e.isSpace()) {
                // Skip spaces in the unlikely event that one was sent
                // into this method by accident.
                elementsWithSpaces.add(e);

                if (i < (elements.size() - 1)) {
                    // If this is NOT the last element in the letter,
                    // add a mid-letter space between elements.
                    elementsWithSpaces.add(Elements.CHAR_UNIT_SPACE);
                }
            }
        }
        return new Letter(elementsWithSpaces);
    }

    public Letter(List<Element> elements) {
        this.elements = elements;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void executeSignal(SignalController controller) {
        elements.forEach(e -> {
            if (e.isOnElement()) {
                // Turn the signal on
                controller.turnOn();
            } else {
                controller.turnOff();
            }
            SystemClock.sleep(TimeUnit.MILLISECONDS.convert(e.getDuration(), Constants.BASE_UNIT));
        });
    }

    public void addSpaceBetweenLetters() {
        elements.add(Elements.LETTER_SPACE);
    }

}
