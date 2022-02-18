package com.simplegeek.morseandroid;

import com.simplegeek.morseandroid.util.Constants;

public class Element {

    private final int duration;
    // Indicates whether this element should turn the signal on or off.
    // True, if this element turns the signal on, false if this element
    // turns the signal off.
    private final boolean isOnElement;
    // Indicates whether this element is a space (not a dot or dash), or not.
    private final boolean isSpace;

    public Element(int duration) {
        this(duration, false, true);
    }

    public Element(int duration, boolean isOnElement, boolean isSpace) {
        this.duration = duration;
        this.isOnElement = isOnElement;
        this.isSpace = isSpace;
    }

    public int getDuration() {
        // The actual duration for this element is whatever constitutes a "base element"
        // multiplied by the duration of this specific element.  So, the duration of a,
        // say, a dot, would be 1 (this.duration) times whatever the base is (Constants.BASE).
        // The base matters because it is the number of base time unit (Constants.BASE_UNIT)
        // that actually constitutes a single "unit" in this program.
        return (this.duration * Constants.BASE);
    }

    public boolean isOnElement() {
        return this.isOnElement;
    }

    public boolean isSpace() {
        return this.isSpace;
    }

}
