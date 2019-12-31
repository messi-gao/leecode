package dy;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for (int i = 2; i < n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(4));
    }
}
