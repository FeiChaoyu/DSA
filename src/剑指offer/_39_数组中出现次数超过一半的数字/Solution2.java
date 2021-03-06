package 剑指offer._39_数组中出现次数超过一半的数字;

import java.util.Arrays;

/**
 * 对数组排序，中间元素就是众数
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(nlogn)
 *
 * @author feichaoyu
 */
public class Solution2 {

    // 题目假设nums不为空
    public int majorityElement(int[] nums) {

        // 直接调用库函数
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
