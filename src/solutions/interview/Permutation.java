package solutions.interview;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        }  else {
            for (int index = start; index <= end; index++) {
                str = swap(str, start, index);
                permute(str, start + 1, end);
                str = swap(str, start, index);
            }
        }
    }

    public static void permute(int[] numbers, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(numbers));
        }  else {
            for (int index = start; index <= end; index++) {
                swap(numbers, start, index);
                permute(numbers, start + 1, end);
                swap(numbers, start, index);
            }
        }
    }

    public static void permute2(ArrayList<Integer> numbers, ArrayList<Integer> values) {
        if (numbers.size() == 0) {
            System.out.println(values.toString());
            values.clear();
        } else {
            for (int index = 0; index <= numbers.size() - 1; index++) {
                var rangeNumbers = new ArrayList<>(numbers);
                rangeNumbers.remove(index);
                values.add(numbers.get(index));

                permute2(rangeNumbers, values);
            }
        }
    }

    private static String swap(String str, int first, int second) {
        char[] chars = str.toCharArray();
        char temp = chars[first];
        chars[first] = chars[second];
        chars[second] = temp;
        return String.valueOf(chars);
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
