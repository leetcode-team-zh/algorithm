class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1){
            return 0;
        }
        int buyPoint = -1;
        int prePrice = -1;
        int n = 1;
        int profits = 0;
        while(n < prices.length){
            
            while(n < prices.length){
                if(prices[n] > prices[n-1]){
                    buyPoint = prices[n-1];
                    prePrice = prices[n];
                    n++;
                    break;
                }
                n++;
            }
            while(n < prices.length && prices[n] > prePrice){
                prePrice = prices[n];
                n++;
            }
            if(prePrice > 0){
                profits +=( prePrice -  buyPoint);
                buyPoint = -1;
                prePrice = -1;
            }
            n++;
        }
        return profits;
    }
}