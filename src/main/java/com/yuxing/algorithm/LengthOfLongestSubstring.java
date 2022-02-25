package com.yuxing.algorithm;

import java.util.*;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的  最长子串  的长度：
 *
 * 示例  1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是  "wke"，所以其长度为 3。
 *       请注意，你的答案必须是 子串 的长度，"pwke"  是一个子序列，不是子串
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.err.println(lengthOfLongestSubstring(s));
        System.err.println(slidingWindowSolveLengthOfLongestSubstring(s));
    }

    /**
     * 滑动窗口解决方案
     * 设置左右指针，标识窗口左右边界，初始值皆为0
     * 1.右指针向前滑动，不断扩充窗口边界，并在向前滑动时记录所滑过的字符
     * 2.当右指针向前滑动遇到重复字符时，停止滑动，开始滑动左侧指针，缩小窗口边界，直到不再存在重复字符
     * 3.比较当前不重复子串(窗口左右边界的差值)与上次记录的大小，保留最大值
     */
    public static int slidingWindowSolveLengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            Integer num = Optional.ofNullable(window.get(c)).orElse(0);
            window.put(c, ++num);
            right++;
            while (window.get(c) > 1) {
                Integer num1 = window.get(s.charAt(left));
                window.put(s.charAt(left), --num1);
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start);
            }
            max = Math.max(max, i - start + 1);
            map.put(c, i);
        }
        return max;
    }
}
