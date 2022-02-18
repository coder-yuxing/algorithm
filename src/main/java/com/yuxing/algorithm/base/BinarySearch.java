package com.yuxing.algorithm.base;

/**
 * 二分查找
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class BinarySearch {

    /**
     * 寻找左侧边界
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
        // [low, high) 左开右闭区间
        while (low < high) {
            int mid = (low + high) / 2;
            // 查到目标值后继续向左侧寻找
            if (nums[mid] == target) {
                high = mid;
            }
            else if (nums[mid] > target) {
                high = mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}
