package ThreeAddTwoNumbersAsLinkedList;

public class Nodell {
    public Nodell(int value) {
        this.value = value;
    }

    public Nodell(int value, Nodell next) {
        this.value = value;
        this.next = next;
    }

    int value;
    Nodell next;

    public void setNext(Nodell next) { this.next = next; }

    public String toString() {
        String returnStr = String.valueOf(value);
        if (next != null) {
            returnStr += ", (" + next + ")";
        }
        return returnStr;
    }
}
