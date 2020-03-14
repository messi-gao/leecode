package half;

/**
 * 二分查找第一个元素
 */
class HalfSearchFirst {
    public int search(int[] nums, int target) {
        int half, left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            half = left + (right - left) / 2;
            if (nums[half] >= target) {
                right = half - 1;
            } else {
                left = half + 1;
            }
            if (left < nums.length && nums[left] == target) {
                return left;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new HalfSearchFirst().search(new int[]{-1, 0, 3, 3, 3, 12}, 3));
    }
}