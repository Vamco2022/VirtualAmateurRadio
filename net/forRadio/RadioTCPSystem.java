package com.vamco.java.system.virtualAmateurRadio.server.net.forRadio;

import com.vamco.java.system.virtualAmateurRadio.server.net.radioPackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RadioTCPSystem {
    public static int inputPort,outputPort;
    public ExecutorService userPool; //tcp用户线程池

    public RadioTCPSystem(int in, int out){
        inputPort = in;
        outputPort = out;
        this.userPool = Executors.newFixedThreadPool(999); //别问我为什么是999，因为一刀999（不是）
        sendRegister.l = new ArrayList<>();
    }

    public void start(){
        while (true){
            try {
                ServerSocket s = new ServerSocket(inputPort);
                Socket user = s.accept();

                userPool.execute(new serverUserThread(user));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void callGlobal(String message){
        //像线程池全局发送信息
        sendRegister.calls(message);
    }

    //全局广播注册类
    static class sendRegister{
        public static List<tcpRadioSends> l;

        public static void add(tcpRadioSends f){
            l.add(f);
        }

        public static void remove(tcpRadioSends f){
            l.remove(f);
        }

        public static void calls(String message){
            for (tcpRadioSends f : l){
                f.send(message);
            }
        }
    }
}

//user's input socket
class serverUserThread implements Runnable,tcpRadioSends {
    Socket userSocket;
    BufferedReader br;
    BufferedWriter bw;

    public serverUserThread(Socket t){
        try {
            this.userSocket = t;
            InputStreamReader isr = new InputStreamReader(t.getInputStream());
            OutputStreamWriter osr = new OutputStreamWriter(t.getOutputStream());
            this.br = new BufferedReader(isr);
            this.bw = new BufferedWriter(osr);
            RadioTCPSystem.sendRegister.add(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(){
        try {
            String rm;
            while (true) {
                rm = br.readLine();
                if (!rm.isEmpty()){
                    if (rm.startsWith("$pack:")){

                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void send(String message) {
        try{
            Socket sendSocket = new Socket(this.userSocket.getInetAddress(),RadioTCPSystem.outputPort);
            OutputStreamWriter osw = new OutputStreamWriter(sendSocket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write(message);
            bw.flush();

            sendSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
