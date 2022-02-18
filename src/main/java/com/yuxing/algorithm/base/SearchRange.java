package com.yuxing.algorithm.base;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] range = searchRange(nums, 8);
        System.err.println(range);
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = findIndex(nums, target, true);
        int lastIndex = findIndex(nums, target, false);
        if (firstIndex <= lastIndex && firstIndex < nums.length && nums[firstIndex] == target && nums[lastIndex] == target) {
            return new int[]{firstIndex, lastIndex};
        }
        return new int[]{-1, -1};
    }

    public static int findIndex(int[] nums, int target, boolean lower) {
        int low = 0, high = nums.length - 1, result = nums.length;
        while (low <= high) {
            int middle = (low + high) / 2;
            // 数组升序排列，第一个大于target的左侧第一个即为target(若存在)
            if (nums[middle] > target || (lower && nums[middle] >= target)) {
                high = middle - 1;
                result = middle;
            } else {
                low = middle + 1;
            }
        }
        return result;
    }
}
