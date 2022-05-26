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
}
