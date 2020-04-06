package com.dpc.algorithm.leetcode;

public class Solution {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }

            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "ab";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }

}

