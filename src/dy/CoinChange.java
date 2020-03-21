package dy;

import java.util.Arrays;

public class CoinChange {
  /*  public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return helper(0, coins, amount);
    }

    private int helper(int index, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (index < coins.length && amount > 0) {
            int maxCount = amount / coins[index];
            int minRes = Integer.MAX_VALUE;
            for (int i = 0; i < maxCount + 1; i++) {
                if (amount >= i * coins[index]) {
                    int helper = helper(index + 1, coins, amount - i * coins[index]);
                    if (helper != -1) {
                        minRes = Math.min(minRes, helper + i);
                    }
                }
            }
            return (minRes == Integer.MAX_VALUE) ? -1 : minRes;
        }

        return -1;
    }*/

    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }


    public static void main(String[] args) {
        int i = new CoinChange().coinChange(new int[]{1, 6, 7}, 30);
        System.out.println(i);
    }
}

