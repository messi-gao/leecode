package dy;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int res = nums[0], max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max * nums[i];
            min = min * nums[i];

            max = Math.max(Math.max(max, min), res);
            min = Math.min(Math.min(max, min), res);

            if (max > res) {
                res = max;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{2, 3, -2, 4}));
    }
}
