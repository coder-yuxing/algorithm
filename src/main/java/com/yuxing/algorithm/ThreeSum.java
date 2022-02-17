package com.yuxing.algorithm;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author yuxing
 * @since 2022/2/17
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        System.err.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1 && nums[0] == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<String> check = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            int num1 = nums[i - 1];
            int num2 = nums[i];
            int twoSum = num1 + num2;
            String s = num1 + "-" + num2;
            if (check.contains(s)) {
                continue;
            }
            check.add(s);
            for (int j = i + 1; j < nums.length; j++) {
                int num3 = nums[j];
                if (twoSum + num3 == 0) {
                    result.add(Arrays.asList(num1, num2, num3));
                    break;
                }
            }
        }
        return result;
    }
}
