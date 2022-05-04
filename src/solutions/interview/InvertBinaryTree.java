package solutions.interview;

import solutions.interview.Models.TreeNode;

public class InvertBinaryTree {
    public static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

        return root;
    }
}
