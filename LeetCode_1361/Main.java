package LeetCode_1361;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int degree[] = new int[n];
        int edge = 0;
        int parent[] = new int[n];
        if (n == 1) return true;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (set.contains(leftChild[i])) {
                    if (edge == i) return false;
                    else {
                        set.add(i);
                        degree[leftChild[i]]++;
                        edge++;
                        parent[leftChild[i]]++;
                    }
                } else {
                    set.add(i);
                    degree[leftChild[i]]++;
                    edge++;
                    parent[leftChild[i]]++;
                }
            }
            if (rightChild[i] != -1) {
                if (set.contains(rightChild[i])) {
                    if (edge - 1 == i) return false;
                    else {
                        set.add(i);
                        degree[rightChild[i]]++;
                        edge++;
                        parent[rightChild[i]]++;
                    }
                } else {
                    set.add(i);
                    degree[rightChild[i]]++;
                    edge++;
                    parent[rightChild[i]]++;
                }
            }
            if (leftChild[i] != -1 || rightChild[i] != -1) degree[i]++;
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0 || degree[i] > 3 || parent[i] > 1) return false;
        }
        if (edge != n - 1) return false;
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: A valid binary tree with 3 nodes
        int n1 = 3;
        int[] leftChild1 = {1, -1, -1};
        int[] rightChild1 = {2, -1, -1};
        boolean result1 = solution.validateBinaryTreeNodes(n1, leftChild1, rightChild1);
        System.out.println("Test Case 1: " + result1);  // Expected output: true

        // Test case 2: An invalid binary tree with a cycle
        int n2 = 3;
        int[] leftChild2 = {1, 2, 0};
        int[] rightChild2 = {-1, -1, -1};
        boolean result2 = solution.validateBinaryTreeNodes(n2, leftChild2, rightChild2);
        System.out.println("Test Case 2: " + result2);  // Expected output: false

        // Test case 3: An invalid binary tree with multiple parents for a node
        int n3 = 4;
        int[] leftChild3 = {1, 2, -1, -1};
        int[] rightChild3 = {3, -1, -1, -1};
        boolean result3 = solution.validateBinaryTreeNodes(n3, leftChild3, rightChild3);
        System.out.println("Test Case 3: " + result3);  // Expected output: false
    }
}

