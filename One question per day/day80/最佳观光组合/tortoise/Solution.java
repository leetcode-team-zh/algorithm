package leetcode.d1014;

public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int max = A[0] + 0;
        for(int i = 1; i < A.length; i++){
            res = Math.max(res,max + A[i] - i);
            max = Math.max(max,A[i] + i);
        }
        return res;
    }
}
