package solutions.interview;

import java.util.HashMap;

public class TwoSum {
    public static int[] findIndices(int[] numbers, int target) {
        HashMap<Integer, Integer> processedNumbers = new HashMap<>();

        for (int index = 0; index < numbers.length; index++) {
            int number = numbers[index];

            if (processedNumbers.containsKey(target - number)) {
                return new int[] {processedNumbers.get(target - number), index};
            } else {
                processedNumbers.put(number, index);
            }
        }

        return null;
    }
}
