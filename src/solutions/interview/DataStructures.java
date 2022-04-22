package solutions.interview;

import java.io.CharArrayReader;
import java.util.*;

public class DataStructures {
    public static void typeOfDataStructures() {
        // Primitive data types.
        char character = 'c';
        int number = 1;
        float decimal = 1.12f;
        double longerDecimal = 1.4555;
        long largeNumber = 444444456413345L;

        Character objCharacter = 'c';
        Integer objNumber = 1;
        Float objDecimal = 1.12f;
        Double objLongerDecimal = 1.4555;
        Long objLargeNumber = 444444456413345L;

        // Lists.
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        // Arrays.
        int[] singleArray = { 3, 4, 5};
        int[][] multiArray = {{ 3, 4, 5}, {5, 6, 7}};

        List<Integer> numberList = Arrays.stream(singleArray).boxed().toList();

        // Key-value pairs.
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        Map<Integer, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        // Stacks and queues, and heap.
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queueList = new LinkedList<>();
        Queue<Integer> queuePriorityList = new PriorityQueue<>();
    }
}
