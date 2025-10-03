class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 0) {
            return 0;
        }

        int write = 0; 
        int read = 0;  

        while (read < n) {
            char currentChar = chars[read];
            int count = 0;

            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write++] = currentChar;

            if (count > 1) {
                String sCount = String.valueOf(count);
                for (char c : sCount.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        return write;
    }
}