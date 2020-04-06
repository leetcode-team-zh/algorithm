package leetcode.d72;

public class Solution {
    public int minDistance(String word1, String word2) {
        //dp
        //A 和 B 最后一个字母相同 D[i][j] = min(D[i][j-1] +1,D[i-1][j]+1,D[i-1][j-1])
        //A 和 B 最后一个字母相同 D[i][j] = 1 + min(D[i][j-1],D[i-1][j],D[i-1][j-1])
        int m = word1.length();
        int n = word2.length();

        if(n == 0  || m == 0){
            return m + n;
        }

        int[][] dp = new int[m + 1][n + 1];

        //边界
        for(int i = 0 ; i < m + 1; i++){
            dp[i][0] = i;
        }

        for(int j = 0; j < n + 1; j++){
            dp[0][j] = j;
        }

        //计算dp
        for(int i = 1 ; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(word1.charAt(i-1) == word2.charAt(j -1)){
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1] -1));
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
