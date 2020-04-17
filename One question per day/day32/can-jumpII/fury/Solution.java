public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }

public boolean canJump(int[] nums) {
        int index = 0;
        int max = 0;
        int target = nums.length - 1;
        if (target == 0) return true;
        while (index <= max) {
            max = Math.max(nums[index] + index, max);
            index++;
            if (max >= target) return true;

        }
        return false;
    }
