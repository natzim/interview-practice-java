package solutions.interview;

import solutions.interview.Models.ListNode;

public class SortLinkedList {
    public static ListNode sort(ListNode head) {
        ListNode sorted = null;
        ListNode currentSorted = null;
        ListNode previousSorted = null;

        ListNode current = head;

        while (current != null) {
            if (sorted == null) {
                sorted = new ListNode(current.value, null);
                currentSorted = sorted;
            } else {
                while(currentSorted != null) {
                    if (currentSorted.value >= current.value) {
                        ListNode nextNode = new ListNode(current.value, currentSorted);

                        if (previousSorted  == null) {
                            sorted = nextNode;
                        } else {
                            previousSorted.next = nextNode;
                        }

                        break;
                    } else {
                        if (currentSorted.next == null) {
                            currentSorted.next = new ListNode(current.value, null);
                            break;
                        }
                    }

                    previousSorted = currentSorted;
                    currentSorted = currentSorted.next;
                }

                previousSorted = null;
                currentSorted = sorted;
            }

            current = current.next;
        }

        return sorted;
    }
}
