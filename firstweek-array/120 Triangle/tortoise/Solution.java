package leetcode.d120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();

       Integer[] dp = triangle.get(n-1).toArray(new Integer[n]);

        //倒推
        for(int i = n-2; i >=0 ;i -- ){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3,4}));
        triangle.add(Arrays.asList(new Integer[]{6,5,7}));
        triangle.add(Arrays.asList(new Integer[]{4,1,8,3}));
        new Solution().minimumTotal(triangle);
    }
}
