package dy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 *
 * @author gaoyh
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] result = new int[size];

        List<Integer> last = triangle.get(size - 1);
        for (int i = 0; i < size; i++) {
            result[i] = last.get(i);
        }

        for (int i = size - 2; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                result[j] = Math.min(result[j], result[j + 1]) + list.get(j);
            }
        }

        return result[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(1));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new MinimumTotal().minimumTotal(list));
    }
}
