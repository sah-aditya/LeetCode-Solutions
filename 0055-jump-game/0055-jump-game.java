class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        int gas = 0;

        for (int i = 0; i < len; i++) {

            if (gas < 0)
                return false;

            else if (gas < nums[i]) {
                gas = nums[i];
            }

            gas--;
        }

        return true;
    }
}