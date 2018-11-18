package com.loki.developeralgorithm.algorithm;

import java.util.HashMap;

/**
 * @Author xujs
 * 罗马数字转整数
 */
public class RomanToIntegerMain {

    public static void main(String[] args) {
        String str = "iii";
        System.out.println(romanToInteger(str));
    }

    public static int romanToInteger(String s) {
        // 将传入字符串先转大写
        s = s.toUpperCase();
        if (null == s || s.length() == 0) {
            return -1;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        int result = map.get(s.charAt(len - 1));

        //int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0 ; i--) {
            System.out.println(i);
            System.out.println(s.charAt(i));
            System.out.println(map.get(s.charAt(i)));
            System.out.println(map.get(s.charAt(i + 1)));
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        return result;
    }

}
