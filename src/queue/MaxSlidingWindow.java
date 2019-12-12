package queue;

import java.util.ArrayDeque;

/**
 * 239. 滑动窗口最大值
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