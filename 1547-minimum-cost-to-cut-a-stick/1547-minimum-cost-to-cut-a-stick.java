class Solution {
    static int dp[][]= new int[103][103];
    public int minCost(int n, int[] cuts) {

        for(int i=0;i<103;i++){
            Arrays.fill(dp[i],-1);
        }
        Arrays.sort(cuts);

        int cut[] = new int[cuts.length + 2];
        cut[0] = 0;
        cut[cuts.length + 1] = n;

        for (int i = 0, j = 1; i < cuts.length; i++, j++) {
            cut[j] = cuts[i];
        }

        return solve(cut, 0, cut.length - 1);
    }

    static int solve(int cut[], int l, int r) {
        if (r - l < 2) {  // Better to check if there are cuts between l and r
            return 0;
        }

        if(dp[l][r]!=-1){
            return dp[l][r];
        }

        int result = Integer.MAX_VALUE;

        // FIXED: index < r (not r-1)
        for (int index = l + 1; index < r; index++) {
            int cost = (cut[r] - cut[l]) + solve(cut, l, index) + solve(cut, index, r);
            result = Math.min(result, cost);
        }

        return dp[l][r]=result;
    }
}