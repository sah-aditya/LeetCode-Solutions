class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][]= new int [coins.length][amount+1];
        for(int col=0;col<=amount;col++){
            if(col%coins[0]==0){
                dp[0][col]=col/coins[0];
            }
            else{
                dp[0][col]=(int)Math.pow(10,9);
            }
        }
        int exclude,include;

        for(int row=1;row<coins.length;row++){
            for(int col=0;col<=amount;col++){
                exclude=dp[row-1][col];
                include=(int)Math.pow(10,9);

                if(coins[row]<=col){
                    include=1+dp[row][col-coins[row]];
                }
                dp[row][col]=Math.min(exclude,include);
            }

        }

        int result = dp[coins.length-1][amount];
        if (result >= (int)Math.pow(10,9)) {
            return -1;
            }
        return result;
        
    }
}