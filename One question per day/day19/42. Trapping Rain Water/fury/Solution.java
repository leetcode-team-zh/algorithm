package com.dpc.algorithm.leetcode;

public class Solution {

    /*
    * Given n non-negative integers representing an elevation map where the width of each bar is 1,
    * compute how much water it is able to trap after raining.
     Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     Output: 6
     */

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max1 = height[0];
        for (int i = 0; i < height.length; i++) {
            max1 = Math.max(max1, height[i]);
            leftMax[i] = max1;
        }

        int max2 = height[height.length - 1];
        for (int j = height.length - 1; j >= 0; j--) {
            max2 = Math.max(max2, height[j]);
            rightMax[j] = max2;
        }

        int num = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) num += min - height[i];

        }
        return num;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));

    }
}

