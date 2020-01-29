package dy;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(4));
    }
}
