package solutions.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDivisors {

    public static boolean isArrayDividable(int[][] numbers) {
        for (int rowColIndex = 0; rowColIndex < numbers.length; rowColIndex++) {
            List<Integer> rowNumbers = new ArrayList<>();
            List<Integer> colNumbers = new ArrayList<>();

            for (int lengthIndex = 0; lengthIndex < numbers.length; lengthIndex++) {
                rowNumbers.add(numbers[rowColIndex][lengthIndex]);
                colNumbers.add(numbers[lengthIndex][rowColIndex]);
            }

            if (!isArrayDividable(rowNumbers.stream().mapToInt(i -> i).toArray()) ||
                !isArrayDividable(colNumbers.stream().mapToInt(i -> i).toArray())) {
                return false;
            }
        }

        return true;
    }

    public static boolean isArrayDividable(int[] numbers) {
        if (numbers != null && numbers.length > 0) {
            int min = Arrays.stream(numbers).min().getAsInt();

            divisorLoop:
            for (int index = 2; index <= min; index++) {
                for (int number : numbers) {
                    if (number % index != 0) {
                        continue divisorLoop;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public static boolean isArrayDividableFully(int[][] numbers) {
        List<Integer> numbersList = Arrays.stream(numbers).flatMapToInt(Arrays::stream).boxed().toList();

        int min = numbersList.stream().sorted().findFirst().orElseThrow();
        min = numbersList.stream().min(Integer::compare).get();

        boolean isDividable = false;

        divisor:
        for (int index = 2; index <= min; index++) {
            for (Integer number : numbersList) {
                if (number % index != 0) {
                    continue divisor;
                }
            }

            isDividable = true;
            break;
        }

        return isDividable;
    }
}