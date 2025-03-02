package com.vamco.java.system.virtualAmateurRadio.client.api.ui;

import java.awt.*;

public class gridBuilder {
    public static GridBagConstraints build(int gx,int gy,int gw,int gh,int anchor,int fill,Insets is){
        GridBagConstraints s = new GridBagConstraints();
        s.gridx = gx;
        s.gridy = gy;
        s.gridwidth = gw;
        s.gridheight = gh;
        s.fill = fill;
        s.anchor = anchor;
        return s;
    }
}
