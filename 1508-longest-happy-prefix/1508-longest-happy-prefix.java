class Solution {
    public static String longestPrefix(String s) {
    int n = s.length();
    int[] lps = new int[n];
    int len = 0; 
    for (int i = 1; i < n; i++) {
        while (len > 0 && s.charAt(i) != s.charAt(len)) {
            len = lps[len - 1]; 
        }
        if (s.charAt(i) == s.charAt(len)) {
            len++;
            lps[i] = len;
        }
    }
    return s.substring(0, lps[n - 1]);
}

}