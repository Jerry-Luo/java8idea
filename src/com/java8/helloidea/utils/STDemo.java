package com.java8.helloidea.utils;

import java.util.StringTokenizer;

/**
 * Demonstrate StringTokenizer.
 * Created by jianwei on 16/7/9.
 */
public class STDemo {

    static String in = "title=Java: The Complete Reference;" +
            "author=Schildt;" +
            "publisher=McGraw-Hill;" +
            "copyright=2014";

    static String myString = "hello1,hello2,hello3,hello4,hello5,hello6,hello7";

    public static void main(String args[]) {
        StringTokenizer st = new StringTokenizer(in, "=;");

        while(st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
        System.out.println("MyTest");
        StringTokenizer mySt = new StringTokenizer(myString, ",");
        while (mySt.hasMoreTokens()){
            System.out.println(mySt.nextToken());
        }
    }
}
