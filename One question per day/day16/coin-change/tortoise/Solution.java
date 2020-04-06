package leetcode.d322;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i =0; i < amount + 1; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 0; i < dp.length; i ++){
            for(int coin : coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i],1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[]{2},3);
    }
}
