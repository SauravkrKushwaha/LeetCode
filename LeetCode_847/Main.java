package LeetCode_847;
import java.util.*;
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetMask = (1 << n) - 1;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        // Initialize the queue with all nodes as starting points
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] nodeInfo = queue.poll();
                int node = nodeInfo[0];
                int mask = nodeInfo[1];

                if (mask == targetMask) {
                    return steps;
                }

                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);

                    if (!visited[neighbor][nextMask]) {
                        queue.offer(new int[] {neighbor, nextMask});
                        visited[neighbor][nextMask] = true;
                    }
                }
            }

            steps++;
        }

        return -1; // This should never be reached if the graph is connected.
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample graph represented as an adjacency list
        int[][] graph = {
                {1, 2, 3},
                {0},
                {0},
                {0}
        };

        int shortestPath = solution.shortestPathLength(graph);
        System.out.println("Length of the shortest path that visits every node: " + shortestPath);
    }
}
