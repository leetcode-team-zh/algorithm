package leetcode.d122;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int max = 0;
//         [-6 4 -2 3 -2 ]
        //后一天与前一天的差价
        int n = prices.length;
        int[] diff = new int[n -1];

        for(int i = 0 ; i < n -1 ; i++){
            diff[i] = prices[i + 1] - prices[i];
        }

        int temp = 0;
//        for(int i = 0; i < n - 1 ; i++){
//            temp = Math.max(temp + diff[i],diff[i]);
//            max = Math.max(max,temp);
//        }
        for(int i = 0; i < n - 1; i++){
            if(diff[i] > 0){
                max = max + diff[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        new Solution().maxProfit(prices);
    }
}
