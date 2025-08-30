class Solution {
    public int trap(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        // Left max array
        int lftmax = arr[0];
        int[] lft = new int[arr.length];
        lft[0] = lftmax;
        for (int i = 1; i < arr.length; i++) {
            lftmax = Math.max(lftmax, arr[i]);
            lft[i] = lftmax;
        }

        // Right max array
        int rtmax = arr[arr.length - 1];
        int[] rt = new int[arr.length];
        rt[arr.length - 1] = rtmax;
        for (int i = arr.length - 2; i >= 0; i--) {
            rtmax = Math.max(rtmax, arr[i]);
            rt[i] = rtmax;
        }

        // Calculate trapped water
        int water = 0;
        for (int i = 0; i < arr.length; i++) {
            water += Math.min(lft[i], rt[i]) - arr[i];
        }

        return water;
    }
}