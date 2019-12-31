package map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return lists;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            //减枝
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsValue(- nums[i] - nums[j])) {
                    lists.add(Arrays.asList(nums[i], nums[j], - nums[i] - nums[j]));
                }
            }
            map.put(i, nums[i]);
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> ints = new ThreeSum().threeSum(new int[]{0, 0, 0, 0});
        ints.forEach(integers -> integers.forEach(System.out::println));
    }
}