package solutions.interview.Models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeWithArray {
    public char value;
    public TreeNodeWithArray[] children;

    public TreeNodeWithArray(char value, TreeNodeWithArray[] children) {
        this.value = value;
        this.children = children;
    }

    public void preOrder() {
        System.out.println(this.value);

        if (children != null) {
            for (TreeNodeWithArray child : children) {
                child.preOrder();
            }
        }
    }

    public void postOrder() {
        if (children != null) {
            for (TreeNodeWithArray child : children) {
                child.postOrder();
            }
        }

        System.out.println(this.value);
    }

    public void breathFirstSearch() {
        Queue<TreeNodeWithArray> que = new LinkedList<>();
        que.add(this);

        while (!que.isEmpty()) {
            TreeNodeWithArray root = que.remove();
            System.out.println(root.value);

            if (root.children != null) {
                Collections.addAll(que, root.children);
            }
        }
    }
}
