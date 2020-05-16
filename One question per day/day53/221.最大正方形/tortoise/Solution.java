package leetcode.d221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                maxSize = 1;
            }
        }

        for(int j = 0; j < cols; j++ ){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                maxSize = 1;
            }
        }

        for(int i = 1; i < rows ;i ++){
            for(int j = 1 ; j < cols; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                    maxSize = Math.max(maxSize,dp[i][j]);
                }
            }
        }

        return maxSize * maxSize;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        new Solution().maximalSquare(chars);
    }
}
