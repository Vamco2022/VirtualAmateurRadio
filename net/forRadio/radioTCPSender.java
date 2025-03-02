package com.vamco.java.system.virtualAmateurRadio.server.net.forRadio;


import com.vamco.java.system.virtualAmateurRadio.server.net.radioPackage;

public class radioTCPSender{
    public static void send(radioPackage[] rp){
        StringBuilder sb = new StringBuilder("$pack:");
        for (int i = 0;i < rp.length;i++){
            sb.append(rp[i].toString());
            if (i < rp.length -1) sb.append(";");
        }

        RadioTCPSystem.callGlobal(sb.toString());
    }
}