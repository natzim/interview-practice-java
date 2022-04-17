package solutions.interview;

public class MissingDuplicateNumber {
    public static int findMissingDuplicateNumber(int[] numbers) {
        int unique = 0;

        for (int number : numbers) {
            unique = unique ^ number;
        }

        return unique;
    }
}
