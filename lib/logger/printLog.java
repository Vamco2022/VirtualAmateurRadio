package com.vamco.java.system.virtualAmateurRadio.server.lib.logger;

//从原来的老项目中复制过来的 Copy from old projects
//printLog 和 COLOR 类
public class printLog {
    public static void printWithColor(String v, COLOR color){
        if (color == COLOR.RED){
            System.out.print("\033[31;1m" + v + "\033[0m");
        }else if (color == COLOR.GREEN){
            System.out.print("\033[32;1m" + v + "\033[0m");
        }else if (color == COLOR.YELLOW){
            System.out.print("\033[33;1m" + v + "\033[0m");
        }else if (color == COLOR.BLUE){
            System.out.print("\033[34;1m" + v + "\033[0m");
        }else{
            System.out.print(v);
        }
    }

    public static void printlnWithColor(String v, COLOR color){
        if (color == COLOR.RED){
            System.out.println("\033[31;1m" + v + "\033[0m");
        }else if (color == COLOR.GREEN){
            System.out.println("\033[32;1m" + v + "\033[0m");
        }else if (color == COLOR.YELLOW){
            System.out.println("\033[33;1m" + v + "\033[0m");
        }else if (color == COLOR.BLUE){
            System.out.println("\033[34;1m" + v + "\033[0m");
        }else{
            System.out.println(v);
        }
    }

    //new function overwrite from old code
    public static void printlnWithColorTag(String tag, String message, COLOR color){
        if (color == COLOR.RED){
            System.out.print("\033[31;1m" + "[" + tag + "]" + "\033[0m");
        }else if (color == COLOR.GREEN){
            System.out.print("\033[32;1m" + "[" + tag + "]" + "\033[0m");
        }else if (color == COLOR.YELLOW){
            System.out.print("\033[33;1m" + "[" + tag + "]" + "\033[0m");
        }else if (color == COLOR.BLUE) {
            System.out.print("\033[34;1m" + "[" + tag + "]" + "\033[0m");
        }else{
            System.out.print("[" + tag + "]");
        }
        System.out.println(" : " + message);
    }
}
