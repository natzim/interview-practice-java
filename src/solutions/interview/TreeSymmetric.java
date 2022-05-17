package solutions.interview;

import solutions.interview.Models.TreeNode;

public class TreeSymmetric {
    public static boolean isTreeSymmetric(TreeNode root) {
        return root == null || checkSymmetry(root.left, root.right);
    }

    private static boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.data == right.data && checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);
        }

        return false;
    }
}
