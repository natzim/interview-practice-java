package OneValidBinarySearchTree;

public class BinaryTreeVerifier {

    public boolean verifyOriginal(BinaryTree binaryTree, Integer min, Integer max) {
        boolean isTreeValid = true;

        if (binaryTree.left != null) {
            int leftVal = binaryTree.left.value;
            if (leftVal >= binaryTree.value || (min != null && leftVal <= min)) {
                return false;
            } else {
                isTreeValid = verifyOriginal(binaryTree.left, binaryTree.left.value, binaryTree.value);
            }
        }

        if (binaryTree.right != null && isTreeValid) {
            int rightVal = binaryTree.right.value;
            if (rightVal <= binaryTree.value || (max != null && rightVal >= max)) {
                return false;
            } else {
                isTreeValid = verifyOriginal(binaryTree.right, binaryTree.value, binaryTree.right.value);
            }
        }

        return isTreeValid;
    }

    public boolean verifyFinal(BinaryTree bt) {
        return verifyFinal(bt, 0, Integer.MAX_VALUE);
    }
    private boolean verifyFinal(BinaryTree bt, int min, int max) {
        if (bt == null) return true;

        if (bt.value <= min || bt.value >= max) return false;
        return verifyFinal(bt.left, min, bt.value) && verifyFinal(bt.right, bt.value, max);
    }

}
