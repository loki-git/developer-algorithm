package com.loki.developeralgorithm.algorithm;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author xujs
 * 输入一段字符串，统计每个字符串出现的次数
 */
public class CountCharMain {

    public static void main(String[] args) {
        // 控制台输入字符串
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个字符串:");
        String str = scanner.nextLine();
        TreeMap<Character, Integer> map = pross(str);
        System.out.println(map);
    }

    public static TreeMap<Character, Integer> pross(String str) {
        // 将字符串转成字符数组
        char[] chars = str.toCharArray();

        // TreeMap默认自然排序，也可用HashMap
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            // 如果map中不存在该字符则put，默认count为1
            if (!treeMap.containsKey(chars[i])){
                treeMap.put(chars[i], 1);
            } else {
                // 如果map中存在，则count + 1数量加1，并且将最新的count存入
                int count = treeMap.get(chars[i]) + 1;
                treeMap.put(chars[i], count);
            }
        }

        return treeMap;
    }

}
