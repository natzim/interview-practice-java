package solutions.interview;

import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {
    public static void minMaxSum(List<Integer> arr) {
        arr = arr.stream().sorted().collect(Collectors.toList());

        long min = 0;
        long max = 0;

        for (int index = 0; index < arr.size() - 1; index++) {
            min += arr.get(index);
            max += arr.get(index+1);
        }

        System.out.println(min + " " + max);
    }
}
