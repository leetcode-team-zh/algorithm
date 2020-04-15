public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null) return null;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (matrix[i][j] == 0) dp[i][j] = 0;
                else {
                    if (inArea(i - 1, j, row, col) && dp[i - 1][j] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (inArea(i, j - 1, row, col) && dp[i][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (inArea(i, j + 1, row, col) && dp[i][j + 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
                if (inArea(i + 1, j, row, col) && dp[i + 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
            }
        }

        return dp;
    }

    private boolean inArea(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        Solution solution = new Solution();
        int[][] dp = solution.updateMatrix(matrix);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }
    }
