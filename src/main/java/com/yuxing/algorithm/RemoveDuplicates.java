package com.yuxing.algorithm;


/**
 * TODO(dingguangren)快慢指针的用法
 *
 * @author yuxing
 * @since 2022/2/15
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4};
        int[] nums1 = {1, 2, 3, 3, 3, 4, 5, 5, 6, 6, 6, 6, 7};
        System.err.println(removeDuplicates(nums));
        System.err.println(removeDuplicates(nums1));
        int[] nums2 = {1,1,2};
        int[] nums3 = {0,0,1,1,1,2,2,3,3,4};
        System.err.println(simpleRemoveDuplicates(nums2));
        System.err.println(simpleRemoveDuplicates(nums3));
    }

    /**
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     *
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     *
     * 将最终结果插入nums 的前 k 个位置后返回 k 。
     *
     * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 判题标准:
     *
     * 系统会用下面的代码来测试你的题解:
     *
     * int[] nums = [...]; // 输入数组
     * int[] expectedNums = [...]; // 长度正确的期望答案
     *
     * int k = removeDuplicates(nums); // 调用
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * 如果所有断言都通过，那么您的题解将被 通过。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     *
     * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
     * 输出：5, nums = [0,1,2,3,4]
     * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
     *
     * @return
     */
    public static int simpleRemoveDuplicates(int[] nums) {
        // 数组中元素不允许重复，即任意两个相邻数值不允许相等
        int length = nums.length;
        if (length <= 1) {
            return length;
        }

        int preNumIndex = 1;
        int currentNumIndex = 1;
        while (currentNumIndex < length) {
            if (nums[preNumIndex - 1] != nums[currentNumIndex]) {
                nums[preNumIndex] = nums[currentNumIndex];
                preNumIndex++;
            }
            currentNumIndex++;
        }
        return preNumIndex;
    }

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums 有序数组
     * @return 删除后数组新长度
     */
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        // 每个元素最多出现两次，数组长度小于等于2必然满足要求
        if (length <= 2) {
            return length;
        }
        // 当前待检查元素的数组下标
        int fast = 2;
        // 上一个已检查元素的数组下标
        int slow = 2;
        while (fast < length) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;

    }

}
