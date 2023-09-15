package LeetCode_1584;
import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();

        // Create edges between all pairs of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, cost));
            }
        }

        // Initialize the parent array for the union-find algorithm
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int minCost = 0;
        int edgeCount = 0;

        // Sort edges by their cost using a priority queue (min-heap)
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(edges);

        while (!minHeap.isEmpty() && edgeCount < n - 1) {
            Edge edge = minHeap.poll();
            int u = edge.u;
            int v = edge.v;
            int cost = edge.cost;

            if (find(parent, u) != find(parent, v)) {
                union(parent, u, v);
                minCost += cost;
                edgeCount++;
            }
        }

        return minCost;
    }

    // Helper function to find the parent of a node using the union-find algorithm
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // Helper function to union two nodes using the union-find algorithm
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }

    class Edge implements Comparable<Edge> {
        int u;
        int v;
        int cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int minCost = solution.minCostConnectPoints(points);

        System.out.println("Minimum cost to connect all points: " + minCost);
    }
}

