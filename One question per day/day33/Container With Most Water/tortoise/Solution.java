package leetcode.d11;

public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int ans = Integer.MIN_VALUE;
        while (l < r){
            int area = Math.min(height[l],height[r]) * (r - l);
            ans = Math.max(area,ans);

            if(height[l] < height[r]){
                ++l;
            }else {
                --r;
            }
        }
        return ans;
    }
}
