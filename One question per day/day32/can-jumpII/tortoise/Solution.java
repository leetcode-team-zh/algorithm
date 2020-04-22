package leetcode.d55;

public class Solution {
    public boolean canJump(int[] nums) {
        //贪心算法[2,3,1,1,4]
        int rightMost = 0;
        int n = nums.length;
        for(int  i = 0 ; i < nums.length ; i++){
            if(i > rightMost){
                return false;
            }
            rightMost = Math.max(rightMost,i + nums[i]);
            if(rightMost >= n - 1){
                return true;
            }
        }
        return false;
    }
}
