package com.vamco.java.system.virtualAmateurRadio.server.api.modeDecode.CW;

public class modeCWBuilder{
    public static modeCW build(String data){
        modeCW r = new modeCW((data.split("`")[0].equals("1"))? true : false);
        return r;
    }
}