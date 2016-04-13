package com.evmaki.d302;

import com.evmaki.d302.rfidreader.Messages;
import com.evmaki.d302.rfidreader.RFIDReader;
import com.evmaki.d302.wedge.KeyboardWedge;

/**
 * The entry point for the RFID reader keyboard wedge. Instantiates an RFID reader connected to the given COM port,
 * then checks for things to scan every sleepTime interval.
 * @author Evan King
 */
public class Main {
    private static final String comPort = "COM5";
    private static final int sleepTime = 500;

    public static void main(String args[]) {
        RFIDReader rfidReader = new RFIDReader(comPort);
        KeyboardWedge wedge = new KeyboardWedge();

        while(rfidReader.isConnected()) {
            try {
                String text = rfidReader.scan();
                if(!text.equals("-1") && !text.equals("210033")) {
                    wedge.type(text);
                }
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

