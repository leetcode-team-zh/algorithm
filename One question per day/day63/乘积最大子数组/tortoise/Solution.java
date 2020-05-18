package leetcode.d152;

import java.util.Arrays;

public class Solution {
    public int maxProduct1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int preMin = nums[0];
        int preMax = nums[0];
        int result = preMax;
        for(int i = 1; i < nums.length; i++){
            int currMin = Math.min(nums[i],Math.min(preMax * nums[i], preMin * nums[i]));
            int currMax = Math.max(nums[i],Math.max(preMax * nums[i], preMin * nums[i]));
            preMin = currMin;
            preMax = currMax;
            result = Math.max(result,currMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        System.out.println(new Solution().maxProduct1(nums));
    }
}
