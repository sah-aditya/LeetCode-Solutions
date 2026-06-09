import java.util.*;

class Solution {

    public int findCheapestPrice(int n,
                                 int[][] flights,
                                 int src,
                                 int dst,
                                 int k) {

        // -----------------------------
        // STEP 1: Create Graph
        // graph[u] = [(v,cost), ...]
        // -----------------------------

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph from flights array
        for (int[] flight : flights) {

            int u = flight[0];     // source city
            int v = flight[1];     // destination city
            int cost = flight[2];  // ticket price

            graph[u].add(new int[]{v, cost});
        }

        // -----------------------------
        // STEP 2: Minimum cost array
        // minCost[i] =
        // cheapest cost to reach city i
        // -----------------------------

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        // -----------------------------
        // STEP 3: BFS Queue
        //
        // queue stores:
        // [city, cost]
        // -----------------------------

        Queue<int[]> q = new LinkedList<>();

        // Start from source city
        q.offer(new int[]{src, 0});

        // Cost to reach source = 0
        minCost[src] = 0;

        // -----------------------------
        // STEP 4: Stops Counter
        //
        // One BFS Level = One Stop
        // -----------------------------

        int stops = 0;

        // Process only till K stops
        while (!q.isEmpty() && stops <= k) {

            // Nodes present in current level
            int size = q.size();

            // Process current BFS level
            while (size-- > 0) {

                int[] curr = q.poll();

                int city = curr[0];
                int currentCost = curr[1];

                // Explore all neighbours
                for (int[] neighbour : graph[city]) {

                    int nextCity = neighbour[0];
                    int flightCost = neighbour[1];

                    // New cost after taking this flight
                    int newCost = currentCost + flightCost;

                    // If not cheaper, skip
                    if (newCost >= minCost[nextCity]) {
                        continue;
                    }

                    // Found better path
                    minCost[nextCity] = newCost;

                    // Add into queue for next stop
                    q.offer(new int[]{
                            nextCity,
                            newCost
                    });
                }
            }

            // One BFS level completed
            // = One Stop Used
            stops++;
        }

        // Destination unreachable
        if (minCost[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return minCost[dst];
    }
}