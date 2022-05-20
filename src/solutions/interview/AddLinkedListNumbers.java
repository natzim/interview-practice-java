package solutions.interview;

import solutions.interview.Models.ListNode;

public class AddLinkedListNumbers {
    public static ListNode addTwoNumbersRecursively(ListNode l1, ListNode l2) {
        //return addTwoNumbersRecursively(l1, l2, 0);
        return addTwoNumbersIteratively(l1, l2);
    }

    public static ListNode addTwoNumbersRecursively(ListNode l1, ListNode l2, int carry) {
        int total = l1.value + l2.value + carry;
        carry = total / 10;

        ListNode answer = new ListNode(total % 10, null);

        if (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new ListNode(0, null);
            }

            if (l2.next == null) {
                l2.next = new ListNode(0, null);
            }

            answer.next = addTwoNumbersRecursively(l1.next, l2.next, carry);
        }

        return answer;
    }

    public static ListNode addTwoNumbersIteratively(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        ListNode answer = new ListNode(0, null);
        ListNode current = null;

        int carry = 0;

        while (a != null || b != null) {
            if (a == null) {
                a = new ListNode(0, null);
            }

            if (b == null) {
                b = new ListNode(0, null);
            }

            int total = a.value + b.value + carry;
            carry = total / 10;

            if (current == null) {
                answer.value = total % 10;
                answer.next = current = new ListNode(0, null);
            } else {
                current.value = total % 10;
                current = current.next = new ListNode(0, null);
            }

            a = a.next;
            b = b.next;
        }

        return answer;
    }
}
