package com.kuang.lesson02;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: com.kuang.lesson02
 * @Author: yuan wang
 * @CreateTime: 2023-01-11  11:25
 * @Description: TODO
 * @Version: 1.0
 */
public class TcpServerDemo02 {
    public static void main(String[] args) throws IOException {
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //2.监听客户端的连接
        Socket socket = serverSocket.accept();//阻塞式监听，会一直等待客户端连接，类似于sc.next();
        //3.获取输入流
        InputStream is = socket.getInputStream();

        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.md"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}
