package com.example.a17231.book.InternetSever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 17231 on 2017/9/5.
 */

public class ClientDemo {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("172.18.25.103",30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println("来自服务器的连接："+line);
        br.close();
        socket.close();

    }
}
