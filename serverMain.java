package com.vamco.java.system.virtualAmateurRadio.server;

import com.vamco.java.system.virtualAmateurRadio.server.lib.logger.COLOR;
import com.vamco.java.system.virtualAmateurRadio.server.lib.logger.printLog;
import com.vamco.java.system.virtualAmateurRadio.server.net.forRadio.RadioTCPSystem;
import com.vamco.java.system.virtualAmateurRadio.server.virtualRadio.globalRadioSystem;

public class serverMain {
    public static int hz = 60;
    public static globalRadioSystem grs;
    public static RadioTCPSystem rts;

    public static void main(String[] args) {
        printLog.printlnWithColorTag("MAIN:INFO", "Start the System...", null);

        grs = new globalRadioSystem(hz);
        rts = new RadioTCPSystem(8895, 8890);

        printLog.printlnWithColorTag("MAIN:INFO", "Start the GRS...", null);
        printLog.printlnWithColorTag("MAIN:INFO", "Start the RTS...", null);

        grs.start();
        printLog.printlnWithColorTag("MAIN:INFO", "Successful to start GRS!", COLOR.GREEN);

        rts.start();
    }
}
