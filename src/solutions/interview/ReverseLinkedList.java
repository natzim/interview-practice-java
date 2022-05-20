package solutions.interview;

import solutions.interview.Models.ListNode;

public class ReverseLinkedList {
    public static ListNode reversedLinkedList(ListNode root) {
        ListNode next = null;
        ListNode current = root;
        ListNode previous = null;

        do {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;

        } while (current != null);

        return previous;
    }

    public static String printLinkedList(ListNode root) {
        if (root == null) {
            return "";
        }

        return root.value + printLinkedList(root.next);
    }

    public static String printLinkedList2(ListNode root) {
        String output = String.valueOf(root.value);

        if (root.next != null) {
            output += printLinkedList2(root.next);
        }

        return output;
    }
}
