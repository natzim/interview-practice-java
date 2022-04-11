package OneValidBinarySearchTree;

public class BinaryTree {
    public BinaryTree(Integer value) {
        this.value = value;
        left = null;
        right = null;
    }

    public BinaryTree(Integer value, BinaryTree left, BinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int value;
    BinaryTree left;
    BinaryTree right;
}