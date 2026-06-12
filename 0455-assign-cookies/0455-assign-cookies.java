import java.util.*;

public class Solution {
    /**
     * Finds the maximum number of children that can be satisfied.
     * 
     * Approach:
     * 1. Sort both arrays: children by hunger, cookies by size.
     * 2. Use two pointers to match smallest child with smallest available cookie.
     * 3. A child is satisfied if cookie size >= child's hunger.
     * 
     * Time Complexity: O(n log n + m log m) due to sorting
     * Space Complexity: O(1) if we don't count sorting space, O(n+m) otherwise
     */
    public int findContentChildren(int[] children, int[] cookies) {
        // Step 1: Sort both arrays in ascending order
        Arrays.sort(children);
        Arrays.sort(cookies);

        // Step 2: Use two pointers
        int childIndex = 0;   // pointer for children array
        int cookieIndex = 0;  // pointer for cookies array
        int satisfiedCount = 0; // count of satisfied children

        // Step 3: Iterate through both arrays
        while (childIndex < children.length && cookieIndex < cookies.length) {
            // If current cookie can satisfy current child
            if (cookies[cookieIndex] >= children[childIndex]) {
                // Child is satisfied
                satisfiedCount++;
                // Move to next child and next cookie
                childIndex++;
                cookieIndex++;
            } else {
                // Current cookie is too small for current child
                // Try next larger cookie (skip this child)
                cookieIndex++;
            }
        }

        return satisfiedCount;
    }


}
