package solutions.interview;

import solutions.interview.Models.ListNode;

public class MergeTwoLists {
    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        ListNode answer = new ListNode(0, null);
        ListNode current = null;

        ListNode a = list1;
        ListNode b = list2;

        while (a != null || b != null) {
            if (current == null) {
                current = answer;
            } else {
                current.next = current = new ListNode(0, null);
            }

            if (a == null) {
                current.value = b.value;
                b = b.next;
            } else if (b == null) {
                current.value = a.value;
                a = a.next;
            } else if (a.value > b.value) {
                current.value = b.value;
                b = b.next;
            } else if (a.value < b.value) {
                current.value = a.value;
                a = a.next;
            } else {
                current.value = a.value;
                current.next = current = new ListNode(b.value, null);
                a = a.next;
                b = b.next;
            }
         }

        return answer;
    }
}
