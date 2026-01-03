class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;

        char[] genes = {'A','C','G','T'};
        Queue<String> q = new LinkedList<>();
        q.add(start);

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(end)) return steps;

                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char g : genes) {
                        arr[i] = g;
                        String next = new String(arr);
                        if (set.contains(next)) {
                            set.remove(next);
                            q.add(next);
                        }
                    }
                    arr[i] = orig;
                }
            }
            steps++;
        }
        return -1;
    }
}
