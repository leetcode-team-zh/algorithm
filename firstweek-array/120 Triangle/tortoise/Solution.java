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

    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        if(n == 1){
            return dp[0][0];
        }
        int minValue = Integer.MAX_VALUE;

        for(int i = 1 ; i < n; i++){
            for(int j=0 ; j <= i; j++){
                if(j == 0){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];
                } else if(j == i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j -1];
                }else{
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j],dp[i-1][j-1]);
                }
                if(i == n- 1){
                    if(minValue > dp[i][j]){
                        minValue = dp[i][j];
                    }
                }
            }
        }
        return minValue;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(new Integer[]{-10}));
//        triangle.add(Arrays.asList(new Integer[]{3,4}));
//        triangle.add(Arrays.asList(new Integer[]{6,5,7}));
//        triangle.add(Arrays.asList(new Integer[]{4,1,8,3}));
        new Solution().minimumTotal2(triangle);
    }
}
