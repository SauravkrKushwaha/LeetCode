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

        // Sort edges by their cost
        Collections.sort(edges, (a, b) -> a.cost - b.cost);

        // Initialize the parent array for the union-find algorithm
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int minCost = 0;
        int edgeCount = 0;

        // Kruskal's algorithm
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int cost = edge.cost;

            if (find(parent, u) != find(parent, v)) {
                union(parent, u, v);
                minCost += cost;
                edgeCount++;
            }

            // Early exit condition: If we've added (n - 1) edges, we have a spanning tree
            if (edgeCount == n - 1) {
                break;
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

    class Edge {
        int u;
        int v;
        int cost;

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
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

