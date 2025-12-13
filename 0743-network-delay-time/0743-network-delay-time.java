// Directed weighted graph where each edge (u, v, w) represents a directed edge from node u to node v with weight w
// Greedy Strategy: Dijkstra's algorithm is a greedy algorithm, meaning that at each step, we want to make the locally optimal choice by choosing the node with the shortest known distance and exploring its neighbors.
// The priority queue helps us quickly find the node with the minimum distance.

// TC - O((V + E) log V)
// SC - O(V + E)
// E - number of edges, V - number of vertices

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Build the graph as an adjacency list: node -> [neighborNode, time(weight)]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: Initialize distance array with infinity
        int[] dist = new int[n + 1]; // nodes labeled from 1 to n
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // source node distance is 0

        // Step 3: Priority Queue to process nodes by shortest known time (time, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k}); // start from node k at time 0

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            // If we already found a shorter path, skip
            if (time > dist[node]) continue;

            // Step 4: Explore all neighbors
            if (graph.containsKey(node)) {
                for (int[] neighbor : graph.get(node)) {
                    int neighborNode = neighbor[0];
                    int travelTime = neighbor[1];
                    int newTime = time + travelTime;

                    // Relaxation: if a shorter path is found
                    if (newTime < dist[neighborNode]) {
                        dist[neighborNode] = newTime;
                        pq.offer(new int[]{newTime, neighborNode});
                    }
                }
            }
        }

        // Step 5: Find the node that takes the longest time
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable node
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
