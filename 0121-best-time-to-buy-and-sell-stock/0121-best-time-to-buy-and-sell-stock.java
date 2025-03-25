class Solution {
    public int maxProfit(int[] prices) {
        int l= prices.length;
        int max_profit=0;
        int buy=prices[0];
        for(int i=1;i<l;i++){
            int max = prices[i]-buy;

            if(max_profit<max){
                max_profit=max;
            }

            if(prices[i]<buy){
                buy=prices[i];
            }
        }

        if(max_profit>0){
            return max_profit;
        }
        else{ return 0;}
    }
}