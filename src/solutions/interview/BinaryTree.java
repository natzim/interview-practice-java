package solutions.interview;

import solutions.interview.Models.TreeNode;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }

        return (root.data > minValue &&
                root.data < maxValue &&
                isBinarySearchTree(root.left, minValue, root.data) &&
                isBinarySearchTree(root.right, root.data, maxValue));
    }
}
