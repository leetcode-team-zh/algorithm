public int jump(int[] nums) { //dp 超时
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);

                }
            }

        }
        return dp[nums.length - 1];
    }

    public int jump1(int[] nums) { // greedy
        int n = nums.length;
        int step = n == 1 ? 0 : 1;
        int max = nums[0];
        int start = 1;
        while (max < n - 1) {
            int curMax = max;
            while (start <= curMax) {
                if (start + nums[start] > max) max = start + nums[start];
                start++;
            }
            start = curMax + 1;
            step++;

        }
        return step;
    }
