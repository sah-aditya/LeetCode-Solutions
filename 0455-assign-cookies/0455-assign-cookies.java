class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length, i = 0, j = 0;

        while (i < m && j < n) {
            if (g[j] <= s[i]) j++;  // Assign cookie to child
            i++;  // Move to next cookie
        }

        return j;
    }
}