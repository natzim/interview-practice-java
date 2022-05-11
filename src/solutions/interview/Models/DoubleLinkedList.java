package solutions.interview.Models;

public class DoubleLinkedList {
    public DoubleNode head;
    public DoubleNode tail;

    public void insert(int value) {
        DoubleNode node = new DoubleNode(value);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }

        tail = node;
    }

    public void remove(int value) {
        DoubleNode node = head;

        do {
            if (node.value == value) {
                if (node == head && node.next != null) {
                    head = node.next;
                } else {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
            }

            node = node.next;
        }  while (node.next != null);
    }
}
