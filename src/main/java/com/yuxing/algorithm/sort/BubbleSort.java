package com.yuxing.algorithm.sort;

/**
 * 冒泡排序算法
 *
 * @author yuxing
 * @since 2022/3/2
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, 1, 5, 4, 7, 8, 6, 9, 0};
        sort(nums);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
