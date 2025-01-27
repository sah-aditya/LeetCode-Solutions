class Solution {
    public boolean isNumber(String s) {
        // Use a regular expression to check if the string is a valid number
        return s.matches("[+-]?([0-9]+\\.?|[0-9]*\\.[0-9]+)([eE][+-]?[0-9]+)?");
    }
}
