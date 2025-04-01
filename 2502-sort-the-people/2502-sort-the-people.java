class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        decreasingSort(names,heights);
        return names;
    }

    public static void decreasingSort(String[] names, int[] heights) {
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (heights[j] < heights[j + 1]) {
                    // Swap heights[j] and heights[j + 1]
                    int temp = heights[j];
                    String temp1=names[j];
                    heights[j] = heights[j + 1];
                    names[j] = names[j + 1];
                    heights[j + 1] = temp;
                    names[j + 1] = temp1;
                }
            }
        }
    }
}