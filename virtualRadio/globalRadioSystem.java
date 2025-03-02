package com.vamco.java.system.virtualAmateurRadio.server.virtualRadio;

import com.vamco.java.system.virtualAmateurRadio.server.net.forRadio.radioTCPSender;
import com.vamco.java.system.virtualAmateurRadio.server.net.radioPackage;

import java.util.ArrayList;
import java.util.List;

public class globalRadioSystem extends Thread{
    public static List<radioPackage> f;

    public globalRadioSystem(){
        f = new ArrayList<>();
    }

    public void start(int hz){
        try {
            while (true) {
                Thread.sleep(1 / hz);
                radioPackage[] r = f.toArray(new radioPackage[]{});
                radioTCPSender.send(r);
                f.clear();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addData(radioPackage v){
        f.add(v);
    }
}
