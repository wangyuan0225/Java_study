package com.kuang.lesson01;

import java.net.InetSocketAddress;

/**
 * @BelongsProject: Java_study
 * @BelongsPackage: com.kuang.lesson01
 * @Author: yuan wang
 * @CreateTime: 2023-01-11  08:47
 * @Description: TODO
 * @Version: 1.0
 */
public class TestInetSockedAddress {
    public static void main(String[] args) {

        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost", 8080);
        System.out.println(inetSocketAddress1);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());//地址
        System.out.println(inetSocketAddress1.getPort());//端口

    }
}
