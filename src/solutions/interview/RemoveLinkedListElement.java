package solutions.interview;

import solutions.interview.Models.ListNode;

public class RemoveLinkedListElement {

    public static ListNode removeElement(ListNode head, int val) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            if (current.value == val && previous == null) {
                head = current.next;
            } else if (current.value == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return head;
    }
}
