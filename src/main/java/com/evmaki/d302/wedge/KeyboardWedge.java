package com.evmaki.d302.wedge;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * A keyboard wedge. Takes passed Strings and outputs them to the keyboard buffer. Allows scans from the RFID reader
 * to be treated as keyboard input.
 * @author Evan King
 */
public class KeyboardWedge {
    private Robot wedgeBot;

    public KeyboardWedge() {
        try {
            wedgeBot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * Instructs the wedge to type the passed text.
     * @param typeText the text to type.
     */
    public void type(String typeText) {
        for(int i=0; i<typeText.length(); i++){
            char c = typeText.charAt(i);
            int keycode = KeyEvent.getExtendedKeyCodeForChar(c);

            wedgeBot.keyPress(keycode);
            wedgeBot.keyRelease(keycode);
        }
    }
}
