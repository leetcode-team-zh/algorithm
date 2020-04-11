public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= N; i++) dp[1][i] = i;
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = j;
                int low = 1, high = j;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (dp[i - 1][mid - 1] < dp[i][j - mid]) low = mid + 1;
                    else high = mid;
                }
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][high - 1], dp[i][j - high]) + 1);
            }

        }
        return dp[K][N];
    }
