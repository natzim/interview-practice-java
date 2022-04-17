package solutions.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueHeight {
    public static void reconstructQueue(int[][] input) {
        List<int[]> sortedQueue = Arrays.stream(input).sorted((o1, o2) -> Integer.compare(o2[0], o1[0])).toList();
        List<int[]> output = new ArrayList<>();

        for (int[] person : sortedQueue) {
            output.add(person[1], person);
        }

        output.forEach(person -> System.out.println(Arrays.toString(person)));
    }
}
