package com.raindown.algorithm.ofstring;

/**
 * @author: RainDown
 * @description: 最长回文子串
 * @date: 2023/12/1 23:33
 * @version: 1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeV1("abaabas"));
    }

    //暴力枚举
    public static String longestPalindrome(String str) {
        //最长回文子串 weuew
        int len = str.length();
        if (len < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        int begin = 0;
        int maxLength = 1;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && islongestPalindrome(chars, i, j)) {
                    begin = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return str.substring(begin, begin + maxLength);
    }

    public static boolean islongestPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    //中心扩散
    public static String longestPalindromeV1(String str) {
        int len = str.length();
        if (len < 2) {
            return str;
        }
        char[] chars = str.toCharArray();
        int begin = 0;
        int maxLength = 1;

        for (int i = 0; i < len - 1; i++) {
            int old = getMaxLenByIndex(chars, i, i);
            int mid = getMaxLenByIndex(chars, i, i + 1);
            int max = Math.max(old, mid);
            if (maxLength < max) {
                begin = i - (max - 1) / 2;
                maxLength= max;
            }

        }

        return str.substring(begin,begin+maxLength);

    }

    public static int getMaxLenByIndex(char[] chars, int left, int right) {
        int length = chars.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < length && chars[i] == chars[j]) {
            --i;
            ++j;
        }
        return j - i - 1;
    }
}
