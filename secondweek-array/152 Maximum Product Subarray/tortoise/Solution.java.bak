package leetcode.d152;

import java.util.Arrays;

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        int result = max;
        for(int i = 1; i < nums.length; i++){
            int tmp = max * nums[i];
            max = Math.max(nums[i],Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i],Math.min(tmp,min * nums[i]));
            result = Math.max(result,max);
        }
        return result;
    }

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
        int[] nums = {2,3,-2,4};
        new Solution().maxProduct(nums);
    }
}
