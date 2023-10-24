package LeetCode_515;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestInEachRow = new ArrayList<>();

        if (root == null) {
            return largestInEachRow;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxInRow = Integer.MIN_VALUE; // Initialize the max to the smallest possible value

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxInRow = Math.max(maxInRow, node.val); // Update the max for this row

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            largestInEachRow.add(maxInRow);
        }

        return largestInEachRow;
    }
}
public class Main {
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Find the largest values in each row
        List<Integer> largestInEachRow = solution.largestValues(root);

        // Print the results
        System.out.println("Largest values in each row:");
        for (int largestValue : largestInEachRow) {
            System.out.println(largestValue);
        }
    }
}

