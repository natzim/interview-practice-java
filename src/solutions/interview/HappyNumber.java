package solutions.interview;

import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int number) {
        HashSet<Integer> visited = new HashSet<>();

        if (number == 1) {
            return true;
        }

        while (number != 1) {
            number = sumOfDigits(number);

            if (visited.contains(number)) {
                return false;
            } else {
                visited.add(number);
            }
        }

        return true;
    }

    private static int sumOfDigits(int number) {
        int output = 0;

        while (number != 0) {
            int digit = number % 10;
            digit = (int) Math.pow(digit, 2);
            output += digit;
            number = number / 10;
        }

        return output;
    }
}
