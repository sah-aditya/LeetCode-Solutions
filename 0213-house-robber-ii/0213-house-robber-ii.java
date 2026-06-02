class Solution {
    public int robLinear(int[] nums, int l, int r) {
        int prev2 = 0, prev1 = 0;
        
        for (int i = l; i <= r; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        return Math.max(
            robLinear(nums, 0, n - 2), // exclude last
            robLinear(nums, 1, n - 1)  // exclude first
        );
    }
}