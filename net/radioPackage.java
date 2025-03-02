package com.vamco.java.system.virtualAmateurRadio.server.net;

import com.vamco.java.system.virtualAmateurRadio.server.api.modeDecode.CW.modeCW;
import com.vamco.java.system.virtualAmateurRadio.server.api.modeDecode.CW.modeCWBuilder;
import com.vamco.java.system.virtualAmateurRadio.server.api.radioCallMode;

public class radioPackage {
    radioCallMode mode; //调制类型
    double freq; //载波频率
    double longitude,latitude; //经、纬度
    Object dataPackage; //包

    public radioPackage(radioCallMode mode, double freq, double loe,double lae, Object data){
        this.mode = mode;
        this.freq = freq;
        this.longitude = loe;
        this.latitude = lae;
        this.dataPackage = data;
    }

    public String toString(){
        //package to String
        //style is:
        //[mode]#[freq]#lon#loe#dataPackage

        StringBuilder sb = new StringBuilder();
        sb.append(this.mode.toString()).append("#");
        sb.append(this.freq).append("#");
        sb.append(this.longitude).append("#");
        sb.append(this.latitude).append("#");
        if (this.mode == radioCallMode.CW) sb.append(((modeCW)this.dataPackage).toString());
        return sb.toString();
    }
}

class radioPackageBuilder{
    public static radioPackage build(String message){
        String[] pl = message.split("#");
        radioCallMode m = null;
        Object obj = null;
        if (pl[0].equals(radioCallMode.CW.toString())){
            m = radioCallMode.CW;
            obj = modeCWBuilder.build(pl[4]);
        }
        radioPackage r = new radioPackage(
                m,
                Double.valueOf(pl[1]),
                Double.valueOf(pl[2]),
                Double.valueOf(pl[3]),
                obj
                );

        return r;
    }
}