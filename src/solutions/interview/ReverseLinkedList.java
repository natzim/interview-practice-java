package solutions.interview;

import solutions.interview.Models.Node;

public class ReverseLinkedList {
    public static Node reversedLinkedList(Node root) {
        Node next = null;
        Node current = root;
        Node previous = null;

        do {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        } while (current != null);

        return previous;
    }

    public static String printLinkedList(Node root) {
        if (root == null) {
            return "";
        }

        return root.value + printLinkedList(root.next);
    }

    public static String printLinkedList2(Node root) {
        String output = String.valueOf(root.value);

        if (root.next != null) {
            output += printLinkedList2(root.next);
        }

        return output;
    }
}
