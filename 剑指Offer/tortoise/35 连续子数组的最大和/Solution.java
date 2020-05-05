package leetcode;

import common.ListNode;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int pre = 0;
        int sum = array[0];

        for(int a : array){
            pre = Math.max(pre + a , a);
            sum = Math.max(sum,pre);
        }

        return sum;
    }
}