class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {

                if (coin <= i) {

                    if (dp[i - coin] != Integer.MAX_VALUE - 1) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE - 1) {
            return -1;
        }

        else {
            return dp[amount];
        }
    }
}