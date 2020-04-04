package leetcode.d42;

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        //每个点左边最大
        for(int i = 1; i < size; i++){
            leftMax[i] = Math.max(height[i],leftMax[i - 1]);
        }
        rightMax[size - 1] = height[size - 1];
        //每个点右边最大
        for(int i = size - 2; i >=0 ; i--){
            rightMax[i] = Math.max(height[i],rightMax[i + 1]);
        }

        for(int i = 1; i < size - 1; i++){
            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return ans;
    }
}
