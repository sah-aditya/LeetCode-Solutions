class Solution {
    public int lengthOfLIS(int[] nums) {
        // Edge case: empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        // dp[i] represents the length of LIS ending at index i
        int[] dp = new int[n];
        
        // Initialize all to 1 (each element forms a subsequence of length 1)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Fill dp array: for each position i, check all previous positions j
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[j] < nums[i], we can extend the subsequence ending at j
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Return the maximum value in dp array
        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }
        
        return maxLength;
    }
}