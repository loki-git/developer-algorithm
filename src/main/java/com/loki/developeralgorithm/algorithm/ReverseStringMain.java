package com.loki.developeralgorithm.algorithm;

/**
 * @Author xujs
 * 将字符串反转
 */
public class ReverseStringMain {

    public static void main(String[] args) {
        String str = "abcde";

        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        return new StringBuffer(str).reverse().toString();
    }

}
