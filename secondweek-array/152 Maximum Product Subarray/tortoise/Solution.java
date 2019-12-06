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

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        new Solution().maxProduct(nums);
    }
}
