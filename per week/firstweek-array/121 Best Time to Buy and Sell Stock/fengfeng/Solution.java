class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1 || prices.length == 0){
            return 0;
        }
        for(int n=0;n<prices.length-1;n++){
            prices[n] = prices[n+1] - prices[n];
        }

        int[] profits =  new int[prices.length - 1];
        profits[0] = prices[0] > 0? prices[0]:0;
        for(int n = 1;n < profits.length;n++){
            profits[n] = Math.max(prices[n],profits[n-1]+prices[n]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int profit:profits){
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
