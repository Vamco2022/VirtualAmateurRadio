package com.vamco.java.system.virtualAmateurRadio.server.api.modeDecode.CW;

public class modeCW {
    public boolean tx;
    public final double band = 100; //unit of band is khz

    public modeCW(boolean type){
        this.tx = type;
    }

     public String toString(){
        return (tx? "1" : "0") + "`100";
     }
}
