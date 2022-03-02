package com.yuxing.algorithm.sort;

/**
 * 给定一个长度为N的整型数组arr，其中有N个互不相等的自然数1~N，请实现arr的排序，但是不要把下标0~N-1位置上的数值通过直接赋值的方式替换成1~N。
 *
 * 要求：时间复杂度为O(N)，额外空间复杂度为O(1)。
 * @author yuxing
 * @since 2022/3/2
 */
public class NaturalArrSort {

    public static void main(String[] args) {
        int[] nums = {10, 2, 3, 1, 5, 4, 7, 8, 6, 9};
        sort(nums);
        System.err.println(nums);
    }

    /**
     * 当数组排序完后，数组内的值域下标之间存在以下关系：
     * nums[i] == i + 1
     * num[num[i] - 1] == nums[i]
     */
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
