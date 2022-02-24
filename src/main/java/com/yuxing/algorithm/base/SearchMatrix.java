package com.yuxing.algorithm.base;

/**
 * 编写一个高效的算法来判断  m x n  矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * @author yuxing
 * @since 2022/2/19
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] ints = {{1}, {3}};
        boolean b = searchMatrix(ints, 3);
        System.err.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 更好的算法是：先在第一列确认其所在行
        // 然后再在所在行确认其具体所在位置
        boolean hasTarget = false;
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target) != -1) {
                hasTarget = true;
                break;
            }
        }

        return hasTarget;
    }

    private static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }
}
