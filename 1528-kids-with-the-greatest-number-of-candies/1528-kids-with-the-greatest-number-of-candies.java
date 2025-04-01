class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> find = new ArrayList<>();
        int largest = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > largest) {
                largest = candies[i];
            }
        }
        int l;
        for (int i = 0; i < candies.length; i++) {
            l = candies[i] + extraCandies;
            if (l >= largest) {
                find.add(true); // Changed append to add
            } else {
                find.add(false); // Changed append to add
            }
        }
        return find;
    }
}