package com.kuang.lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: com.kuang.lesson02
 * @Author: yuan wang
 * @CreateTime: 2023-01-11  10:13
 * @Description: 服务端
 * @Version: 1.0
 */
public class TcpServerDemo01 {

    private static ByteArrayOutputStream baos;
    private static InputStream is;
    private static Socket socket;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            //1.得有一个地址
            serverSocket = new ServerSocket(9999);

            while (true) {
                //2.等待客户端连接过来
                socket = serverSocket.accept();
                //3.读取客户端的消息
                is = socket.getInputStream();


                //管道流
                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }

                System.out.println(baos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
