package com.evmaki.d302.rfidreader;

import gnu.io.NRSerialPort;
import gnu.io.RXTXPort;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Chinese D302 RFID reader communication class. Designed to enable the use of the reader as a keyboard wedge which
 * actively scans and enters RFID tag numbers while the program is running.
 * @author Evan King
 */
public class RFIDReader{
    private NRSerialPort serialPort;
    private int baudRate = 4800;

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    /**
     * The RFID reader accepts the name of the COM port it's connected to and connects automatically when instantiated.
     * If everything went well, the reader should beep.
     */
    public RFIDReader(String portName) {
        serialPort = new NRSerialPort(portName, baudRate);
        connect();
    }

    /**
     * Instructs the reader to scan whatever is near it, returning the String associated with the ID of the object it
     * scanned.
     * @return an RFID number, empty if nothing was scanned.
     */
    public String scan() {
        String id = "";
        int frag;

        try {
            outputStream.write(Messages.scanMessage());

            while((frag = inputStream.read()) != -1) {
                id += frag;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Returns the current connectivity of the scanner.
     * @return true if the RFID reader is connected.
     */
    public boolean isConnected(){
        return serialPort.isConnected();
    }

    /**
     * Connects to the RFID reader and sends it a greeting message. On success, the RFID reader will beep.
     * @return whether or not we successfully connected to the reader.
     */
    private boolean connect() {
        boolean isConnected = serialPort.connect();

        if(isConnected) {
            RXTXPort lowLevelPort = serialPort.getSerialPortInstance();
            lowLevelPort.setDTR(true);
            lowLevelPort.setRTS(true);

            inputStream = new DataInputStream(serialPort.getInputStream());
            outputStream = new DataOutputStream(serialPort.getOutputStream());
        }
        else return false;

        try {
            outputStream.write(Messages.greetMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
