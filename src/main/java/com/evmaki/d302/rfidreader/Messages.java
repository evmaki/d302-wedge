package com.evmaki.d302.rfidreader;

/**
 * Some frequently used messages sent to the RFID reader.
 * @author Evan King
 */
public class Messages {
    private static final byte[] greetMsg = {02, 01, 00, 00, 03, 03};
    private static final byte[] scanMsg = {02, 01, (byte)0xa4, 0x0b, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, (byte)0xac, 03};

    /**
     * Returns the greeting message sent to the RFID reader. Used when first connecting, to enable scans.
     * @return the greeting message.
     */
    public static byte[] greetMessage() {
        return greetMsg;
    }

    /**
     * Returns the scan message, which instructs the reader to scan whatever is nearby.
     * @return the scan message.
     */
    public static byte[] scanMessage() {
        return scanMsg;
    }
}
