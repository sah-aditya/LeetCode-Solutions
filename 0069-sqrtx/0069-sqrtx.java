class Solution {
    public int mySqrt(int x) {
        // Handle edge case for negative input
        if (x < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }

        // Special case for 0 and 1
        if (x == 0 || x == 1) {
            return x;
        }

        // Use integer division for better performance
        int left = 1;
        int right = x / 2;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;  // Update result when mid * mid is less than or equal to x
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
