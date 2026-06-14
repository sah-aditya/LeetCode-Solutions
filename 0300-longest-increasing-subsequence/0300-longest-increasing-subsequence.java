import java.util.*;

class Solution {
    int n;
    int[][] dp;
    
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n][n + 1];  // n+1 to accommodate prev index +1 offset
        
        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(nums, 0, -1);
    }
    
    int solve(int[] nums, int i, int prev) {
        // Base case
        if (i >= n) {
            return 0;
        }
        
        // Convert prev index to 0-based for dp array (shift by +1)
        // prev = -1 becomes index 0 in dp
        // prev = 0 becomes index 1 in dp, etc.
        int dpIndex = prev + 1;
        
        // Check memoization
        if (prev != -1 && dp[i][dpIndex] != -1) {
            return dp[i][dpIndex];
        }
        
        // Option 1: Skip current element
        int skip = solve(nums, i + 1, prev);
        
        // Option 2: Take current element if valid
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(nums, i + 1, i);
        }
        
        // Store result in dp (only if prev is valid for memoization)
        int result = Math.max(take, skip);
        if (prev != -1) {
            dp[i][dpIndex] = result;
        }
        
        return result;
    }
}