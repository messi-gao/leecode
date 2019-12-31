package queue;

import java.util.ArrayDeque;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 */
class MaxSlidingWindow {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && deq.getFirst() <= i - k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[deq.getLast()] <= nums[i]) {
                deq.removeLast();
            }
            deq.addLast(i);

            if (i >= k - 1) {
                output[i - k + 1] = nums[deq.getFirst()];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] x = new MaxSlidingWindow().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}