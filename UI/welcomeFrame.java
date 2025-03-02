package com.vamco.java.system.virtualAmateurRadio.client.UI;

import com.vamco.java.system.virtualAmateurRadio.client.api.ui.gridBuilder;

import javax.swing.*;
import java.awt.*;

public class welcomeFrame {
    public static void show(){
        JFrame window = new JFrame("Welcome to use the VirtualAmateurRadio!");
        window.setSize(600,400);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义元素布局，采用GridBagLayout布局
        GridBagLayout box = new GridBagLayout();
        JLabel t1 = new JLabel("服务器IP地址: ");
        JLabel t2 = new JLabel("服务器Input端口: ");
        JLabel t3 = new JLabel("服务器Output端口: ");
        JTextField serverIPInput = new JTextField("服务器IP地址",20);
        JTextField serverInputPort = new JTextField("服务器Input端口",20);
        JTextField serverOutputPort = new JTextField("服务器Output端口",20);
        JButton connectButton = new JButton("连接服务器");
        //connectButton.setSize(100,80);

        //添加元素到容器中
        box.setConstraints(t1, gridBuilder.build(0,0,1,1,
                GridBagConstraints.EAST,GridBagConstraints.NONE,new Insets(0,0,0,5)));
        box.setConstraints(serverIPInput, gridBuilder.build(1,0,1,1,
                GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(0,5,0,0)));
        //line 2
        box.setConstraints(t2, gridBuilder.build(0,1,1,1,
                GridBagConstraints.EAST,GridBagConstraints.NONE,new Insets(0,0,0,5)));
        box.setConstraints(serverInputPort, gridBuilder.build(1,1,1,1,
                GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(0,5,0,0)));
        //line 3
        box.setConstraints(t3, gridBuilder.build(0,2,1,1,
                GridBagConstraints.EAST,GridBagConstraints.NONE,new Insets(0,0,0,5)));
        box.setConstraints(serverOutputPort, gridBuilder.build(1,2,1,1,
                GridBagConstraints.WEST,GridBagConstraints.BOTH,new Insets(0,5,0,0)));
        //line 4
        box.setConstraints(serverIPInput, gridBuilder.build(0,3,1,1,
                GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,0,0,0)));

        //显示元素
        window.add(t1);
        window.add(serverIPInput);
        window.add(t2);
        window.add(serverInputPort);
        window.add(t3);
        window.add(serverOutputPort);
        window.add(connectButton);
        window.setLayout(box);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
