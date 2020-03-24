package leetcode.m17;

public class Solution {
    public int massage(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int dp0 = 0;
        int dp1 = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            int s1 = Math.max(dp0,dp1);
            int s2 = dp0 + nums[i];
            dp0 = s1;
            dp1 = s2;
        }
        return Math.max(dp0,dp1);
    }
}
