package solutions.interview;

import com.sun.source.tree.Tree;
import solutions.interview.Models.TreeNode;

import java.util.List;

public class TreeFromSortedArray {
    public static TreeNode arrayToTree(int[] numbers) {
        return helper(0, numbers.length - 1, numbers);
    }

    private static TreeNode helper(int left, int right, int[] numbers) {
        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;

        TreeNode root = new TreeNode(numbers[middle]);
        root.left = helper(left, middle - 1, numbers);
        root.right = helper(middle + 1, right, numbers);

        return root;
    }
}
