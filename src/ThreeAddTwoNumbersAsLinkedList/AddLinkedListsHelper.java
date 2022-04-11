package ThreeAddTwoNumbersAsLinkedList;

public class AddLinkedListsHelper {

    public Nodell addLinkedListsRecursive(Nodell a, Nodell b) {
        return addLinkedListsRecursive(a, b, 0);
    }

    private Nodell addLinkedListsRecursive(Nodell a, Nodell b, int carry) {
        int addedVal = a.value + b.value + carry;
        int newCarry = Math.floorDiv(addedVal, 10);

        Nodell result = new Nodell(addedVal % 10);

        if (a.next != null || b.next != null) {
            if (a.next == null) {
                a.next = new Nodell(0);
            } else if (b.next == null) {
                b.next = new Nodell(0);
            }
            result.setNext(addLinkedListsRecursive(a.next, b.next, newCarry));
        } else if (newCarry > 0) {
            result.setNext(new Nodell(newCarry));
        }

        return result;
    }

    public Nodell addLinkedListsIterative(Nodell a, Nodell b) {
        Nodell result = null;
        Nodell current = null;
        int carry = 0;

        while (a != null || b != null) {
            if (a == null) {
                a = new Nodell(0);
            } else if (b == null) {
                b = new Nodell(0);
            }

            int addedVal = a.value + b.value + carry;
            Nodell resultNode = new Nodell(addedVal % 10);

            if (result == null) {
                result = resultNode;
                current = resultNode;
            } else {
                current.next = resultNode;
                current = current.next;
            }

            a = a.next;
            b = b.next;
            carry = Math.floorDiv(addedVal, 10);
        }

        return result;
    }
}
