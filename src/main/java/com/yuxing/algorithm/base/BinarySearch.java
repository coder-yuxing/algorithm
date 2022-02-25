package com.yuxing.algorithm.base;

/**
 * 二分查找
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int i = binarySearch(nums, 2);
        System.err.println(i);

        nums = new int[]{1, 2, 2, 2, 2, 3, 4, 5};
        System.err.println(leftBoundaryByBinarySearch(nums, 2) == 1);

        nums = new int[]{1, 2, 3, 4, 4, 4, 5, 6};
        System.err.println(leftBoundaryByBinarySearch(nums, 4) == 3);
    }



    /**
     * 二分查找获取左边界
     */
    public static int leftBoundaryByBinarySearch(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        if (left >= n || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int binarySearch(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int left = 0, right = n - 1;
        // 左右边界相等时退出循环
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
