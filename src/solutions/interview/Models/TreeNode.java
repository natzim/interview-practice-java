package solutions.interview.Models;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }

    public static String preOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        return root.data + preOrder(root.left) + preOrder(root.right);
    }

    public static String inOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        return inOrder(root.left) + root.data + inOrder(root.right);
    }

    public static String postOrder(TreeNode root) {
        if (root == null) {
            return "";
        }

        return postOrder(root.left) + postOrder(root.right) + root.data;
    }

    public static void bfs(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.remove();
            System.out.println(node.data);

            if (node.left != null) {
                que.add(node.left);
            }

            if (node.right != null) {
                que.add(node.right);
            }
        }
    }

    public static int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return root.data + leftSum + rightSum;
    }

    public static int max(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Integer.max(root.data, Integer.max(leftMax, rightMax));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Integer.max(leftHeight, rightHeight);
    }

    public static boolean exists(TreeNode root, int value) {
        if (root == null) {
            return false;
        }

        boolean existsLeft = exists(root.left, value);
        boolean existsRight = exists(root.right, value);

        return root.data == value || existsLeft || existsRight;
    }

    public static void reverse(TreeNode root) {
        if (root == null) {
            return;
        }

        reverse(root.left);
        reverse(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = right;
        root.right = left;
    }
}
