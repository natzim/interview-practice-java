package solutions.interview;

import solutions.interview.Models.Node;

public class AddLinkedListNumbers {
    public static Node addTwoNumbersRecursively(Node l1, Node l2) {
        //return addTwoNumbersRecursively(l1, l2, 0);
        return addTwoNumbersIteratively(l1, l2);
    }

    public static Node addTwoNumbersRecursively(Node l1, Node l2, int carry) {
        int total = l1.value + l2.value + carry;
        carry = total / 10;

        Node answer = new Node(total % 10, null);

        if (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1.next = new Node(0, null);
            }

            if (l2.next == null) {
                l2.next = new Node(0, null);
            }

            answer.next = addTwoNumbersRecursively(l1.next, l2.next, carry);
        }

        return answer;
    }

    public static Node addTwoNumbersIteratively(Node l1, Node l2) {
        Node a = l1;
        Node b = l2;

        Node answer = new Node(0, null);
        Node current = null;

        int carry = 0;

        while (a != null || b != null) {
            if (a == null) {
                a = new Node(0, null);
            }

            if (b == null) {
                b = new Node(0, null);
            }

            int total = a.value + b.value + carry;
            carry = total / 10;

            if (current == null) {
                answer.value = total % 10;
                answer.next = current = new Node(0, null);
            } else {
                current.value = total % 10;
                current = current.next = new Node(0, null);
            }

            a = a.next;
            b = b.next;
        }

        return answer;
    }
}
