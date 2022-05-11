package solutions.interview.Models;

public class DoubleNode {
    public int value;
    public DoubleNode next;
    public DoubleNode previous;

    public DoubleNode (int data) {
        this.value = data;
    }

    public DoubleNode (int data, DoubleNode next) {
        this.value = data;
        this.next = next;
    }

    public DoubleNode (int data, DoubleNode next, DoubleNode previous) {
        this.value = data;
        this.next = next;
        this.previous = previous;
    }
}
