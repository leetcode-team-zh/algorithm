public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (curSum <= 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
