package com.yuxing.algorithm.sort;

/**
 * 选择排序
 *
 * @author yuxing
 * @since 2022/3/2
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, 1, 5, 4, 7, 8, 6, 9, 0};
        sort(nums);
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int smaller = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[smaller] > nums[j]) {
                    smaller = j;
                }
            }

            if (smaller != i) {
                int temp = nums[i];
                nums[i] = nums[smaller];
                nums[smaller] = temp;
            }
        }

    }
}
