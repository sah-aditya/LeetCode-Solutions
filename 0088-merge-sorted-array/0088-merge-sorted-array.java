class Solution {
    /**
     * Merge two sorted arrays into one sorted array.
     * 
     * @param nums1 The first sorted array.
     * @param m      The number of elements in nums1.
     * @param nums2  The second sorted array.
     * @param n      The number of elements in nums2.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Create a new array to store the merged result
        int[] num3 = new int[m + n];

        // Initialize indices for nums1, nums2, and num3
        int k = 0, j = 0;
        int i = 0;

        // Merge smaller elements from nums1 and nums2 into num3
        while (k < m && j < n) {
            // Compare current elements of nums1 and nums2
            if (nums1[k] < nums2[j]) {
                // If nums1's element is smaller, add it to num3
                num3[i] = nums1[k];
                k++; // Move to the next element in nums1
            } else {
                // If nums2's element is smaller, add it to num3
                num3[i] = nums2[j];
                j++; // Move to the next element in nums2
            }
            i++; // Move to the next position in num3
        }

        // Add any remaining elements from nums1
        while (k < m) {
            num3[i] = nums1[k];
            k++;
            i++;
        }

        // Add any remaining elements from nums2
        while (j < n) {
            num3[i] = nums2[j];
            j++;
            i++;
        }

        // Copy the merged result back into nums1
        for (i = 0; i < (m + n); i++) {
            nums1[i] = num3[i];
        }
        return;
    }
}