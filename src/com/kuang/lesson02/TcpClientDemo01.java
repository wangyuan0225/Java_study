package com.kuang.lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: com.kuang.lesson02
 * @Author: yuan wang
 * @CreateTime: 2023-01-11  10:12
 * @Description: 客户端
 * @Version: 1.0
 */
public class TcpClientDemo01 {

    private static OutputStream os;
    private static Socket socket;

    public static void main(String[] args) {


        try {
            //1.要知道服务器的地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //2.创建一个socket连接
            socket = new Socket(serverIP, port);
            //3.发送消息IO流
            os = socket.getOutputStream();
            os.write("你好，欢迎能够学习狂神说Java".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
