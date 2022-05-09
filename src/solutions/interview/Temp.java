package solutions.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        System.out.println(sparseArrays(Arrays.asList("4", "aba", "baba", "aba", "xzxb"), Arrays.asList("3", "aba", "xzxb", "ab")));
        System.out.println(findMedian(Arrays.asList(0, 1, 2, 4, 6, 5, 3)));
        System.out.println(lonelyInteger(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
    }

    public static List<Integer> sparseArrays(List<String> strings, List<String> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (String word : strings) {
            map.merge(word, 1, Integer::sum);
        }

        for (String query : queries) {
            results.add(map.getOrDefault(query, 0));
        }

        return results;
    }

    public static int findMedian(List<Integer> arr) {
        List<Integer> sortedArr = arr.stream().sorted().toList();
        return sortedArr.get(sortedArr.size() / 2);
    }

    public static int lonelyInteger(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer number : arr) {
            map.merge(number, 1, Integer::sum);

            if (map.get(number) >= 2) {
                map.remove(number);
            }
        }

        for (Integer lonelyInteger : map.keySet()) {
            return lonelyInteger;
        }

        return 0;
    }
}
