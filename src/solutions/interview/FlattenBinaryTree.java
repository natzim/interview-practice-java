package solutions.interview;

import solutions.interview.Models.TreeNode;

import java.util.ArrayList;

public class FlattenBinaryTree {

    public static ArrayList<Integer> flattenedArray = new ArrayList<>();
    public static TreeNode flattened;

    public static void flatten(TreeNode root, TreeNode nextNode) {
        if (root == null) {
            return;
        }

        flattenedArray.add(root.data);

        nextNode.data = root.data;
        nextNode.right = new TreeNode(0);

        flatten(root.left, nextNode.right);
        flatten(root.right, nextNode.right);
    }
}
