package com.vamco.java.system.virtualAmateurRadio.server;

import com.vamco.java.system.virtualAmateurRadio.server.net.forRadio.RadioTCPSystem;
import com.vamco.java.system.virtualAmateurRadio.server.virtualRadio.globalRadioSystem;

public class serverMain {
    public static int hz = 60;
    public static globalRadioSystem grs;
    public static RadioTCPSystem rts;

    public static void main(String[] args) {
        grs = new globalRadioSystem();
        rts = new RadioTCPSystem(8895, 8896);
        grs.start(hz);
        rts.start();
    }
}
