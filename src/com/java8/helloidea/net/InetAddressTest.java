package com.java8.helloidea.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Demonstrate InetAddress.
 * Created by jianwei on 16/7/18.
 */
public class InetAddressTest {
    public static void main(String args[]) throws UnknownHostException {

        InetAddress Address = InetAddress.getLocalHost();
        System.out.println(Address);

        Address = InetAddress.getByName("www.HerbSchildt.com");
        System.out.println(Address);

        InetAddress SW[] = InetAddress.getAllByName("www.baidu.com");
        for (int i=0; i<SW.length; i++)
            System.out.println(SW[i]);
    }
}
