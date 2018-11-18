package com.loki.developeralgorithm.algorithm;

/**
 * @Author xujs
 * 给定一个有符号整数，将整数中的数字反转
 */
public class ReverseIntMain {

    public static void main(String[] args) {
        int x = -12345;

        System.out.println(reverse(x));
    }

    /**
     * 复杂度分析：
     *
     * 时间复杂度：O(log(x))，x 中大约有 log10(x) 位数字。
     * 空间复杂度：O(1))。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }

        return rev;
    }

}
