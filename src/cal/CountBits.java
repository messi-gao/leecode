package cal;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @author gaoyh
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ints[i] = (ints[i & (i - 1)]) + 1;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new CountBits().countBits(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
