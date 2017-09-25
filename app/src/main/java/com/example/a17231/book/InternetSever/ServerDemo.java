package com.example.a17231.book.InternetSever;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 17231 on 2017/9/5.
 */

public class ServerDemo {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(30000);
        while(true){
            Socket s = ss.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("圣诞快乐！");
            ps.close();
            s.close();
        }

    }



}
