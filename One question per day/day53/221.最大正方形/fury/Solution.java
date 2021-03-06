public class Solution {
    //在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
    //
    //示例:
    //
    //输入:
    //
    //1 0 1 0 0
    //1 0 1 1 1
    //1 1 1 1 1
    //1 0 0 1 0
    //
    //输出: 4

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix.length > 0 ? matrix[0].length : 0;
        int dp[][] = new int[row][col];
        int maxLen = 0;
        for (int i = 0; i < col; i++)
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxLen = 1;
            }
        for (int i = 0; i < row; i++)
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxLen = 1;
            }
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > maxLen) maxLen = dp[i][j];
                }
            }
        return maxLen * maxLen;
    }
}

