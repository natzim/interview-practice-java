package solutions.interview;

import java.math.BigInteger;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        StringBuilder numberBuilder = new StringBuilder();

        for(int digit : digits) {
            numberBuilder.append(digit);
        }

        BigInteger number = new BigInteger(numberBuilder.toString());
        number = number.add(BigInteger.valueOf(1));

        char[] numbers = number.toString().toCharArray();
        int[] output = new int[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            output[index] = Character.getNumericValue(numbers[index]);
        }

        return output;
    }

    public static int[] plusOneFaster(int[] digits) {
        int carry = 0;
        int lastIndex = digits.length - 1;

        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
        } else {
            for (int index = digits.length - 1; index >= 0; index--) {
                if (digits[index] == 9) {
                    digits[index] = 0;
                    carry = 1;
                } else {
                    digits[index] = digits[index] + carry;
                    carry = 0;
                    break;
                }
            }
        }

        if (carry == 0) {
            return digits;
        } else {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            System.arraycopy(digits, 1, output, 1, digits.length - 1);
            return output;
        }
    }
}
