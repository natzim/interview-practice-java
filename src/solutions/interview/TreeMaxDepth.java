package solutions.interview;

import org.javatuples.Pair;
import solutions.interview.Models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMaxDepth {
    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    public static int maxDepthIterative(TreeNode root) {
        int level = 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            var stackValue = stack.pop();
            var childNode = stackValue.getValue0();
            var depth = stackValue.getValue1();

            if (childNode != null) {
                level = Math.max(level, depth);
                stack.add(new Pair<>(childNode.left, depth + 1));
                stack.add(new Pair<>(childNode.right, depth + 1));
            }
        }

        return level;
    }

    public static int maxDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int queSize = que.size();

            for (int index = 0; index < queSize; index++) {
                TreeNode child = que.remove();

                if (child.left != null) {
                    que.add(child.left);
                }

                if (child.right != null) {
                    que.add(child.right);
                }
            }

            level++;
        }

        return level;
    }
}
