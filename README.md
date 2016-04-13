# d302-wedge
Allows this particular model of RFID reader to wait for tags to scan. As compatible RFID tags come in range, the scanner will automatically scan them and write their associated 18 bit number to the keyboard buffer.

Originally ordered the RFID reader expecting this functionality to be built-in but found that the provided software was only designed to read/write tags on command (rather than the scanner waiting to scan tags). I did a little reverse engineering and ended up here - this should provide a decent example of using [RXTX](https://github.com/rxtx/rxtx) (via [nrjavaserial](https://github.com/NeuronRobotics/nrjavaserial)) for talking to devices on a COM port.

# Frameworks
* [nrjavaserial](https://github.com/NeuronRobotics/nrjavaserial), a simple implementation of the [RXTX](https://github.com/rxtx/rxtx) Java library for talking to devices on COM ports.

# See also
* [Serial Port Monitor](http://www.eltima.com/products/serial-port-monitor/), a piece of software for monitoring serial port traffic. Came in handy while reverse-engineering the device.
* [D302](http://www.aliexpress.com/item/125khz-EM-ID-USB-rfid-reader-and-writer-USB-Desktop-reader-card-issuing-device-no-driver/32326850126.html), the RFID reader this is built to work with.
