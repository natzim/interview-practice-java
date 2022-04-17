package solutions.interview;

import java.util.*;

public class DataStructures {
    public static void typeOfDataStructures() {
        // Lists.
        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> arrayList = new ArrayList<>();

        // Arrays.
        int[] singleArray = { 3, 4, 5};
        int[][] multiArray = {{ 3, 4, 5}, {5, 6, 7}};

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
