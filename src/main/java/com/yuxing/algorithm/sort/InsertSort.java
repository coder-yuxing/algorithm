package com.yuxing.algorithm.sort;

/**
 * 直接插入排序
 *
 * @author yuxing
 * @since 2022/3/2
 */
public class InsertSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = temp;
        }
    }
}
