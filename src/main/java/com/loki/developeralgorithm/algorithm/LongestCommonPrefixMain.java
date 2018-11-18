package com.loki.developeralgorithm.algorithm;

/**
 * @Author xujs
 * 最长公共前缀
 * 输入:["admin", "administrator", "admin_test"]
 * 返回:admin
 */
public class LongestCommonPrefixMain {

    public static void main(String[] args) {
        String[] strs = {"admin", "administrator", "admin_test"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * 返回最长公共前缀
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if (count != 0) {
            prefix = strs[0];
        }

        for (int i = 0; i < count; i++) {
            while (!strs[i].startsWith(prefix)) {
                // 不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
