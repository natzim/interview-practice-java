package solutions.interview.Models;

public class Node {
    public int value;
    public Node next;

    public Node (int data, Node nextNode) {
        this.value = data;
        this.next = nextNode;
    }
}
