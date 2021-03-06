package com.yuxing.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。

 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author yuxing
 * @since 2022/2/15
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = towSum(nums, 9);

        int[] nums1 = {3, 3};
        System.err.println(towSum(nums1, 6));

    }

    public static int[] towSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            Integer otherNumIndex = map.get(target - currentNum);
            if (otherNumIndex != null) {
                return new int[]{otherNumIndex, i};
            }
            map.put(currentNum, i);
        }
        return new int[0];
    }
}
