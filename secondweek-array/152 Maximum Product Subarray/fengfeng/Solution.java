class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        mins[0] = nums[0];
        maxs[0] = nums[0];

        for(int n=1;n<nums.length;n++){
            mins[n] = Math.min(nums[n],Math.min(nums[n]*maxs[n-1],nums[n]*mins[n-1]));
            maxs[n] = Math.max(nums[n],Math.max(nums[n]*maxs[n-1],nums[n]*mins[n-1]));
        }
        int maxValue = Integer.MIN_VALUE;
        for(int num : maxs){
            if(num > maxValue){
                maxValue = num;
            }
        }
        return maxValue;
    }
}
