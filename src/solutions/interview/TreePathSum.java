package solutions.interview;

import solutions.interview.Models.TreeNode;

public class TreePathSum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return getSum(root, targetSum, 0);
    }

    public static boolean getSum(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return targetSum == sum + root.data;
        }

        sum += root.data;
        return getSum(root.left, targetSum, sum) || getSum(root.right, targetSum, sum);
    }
}
