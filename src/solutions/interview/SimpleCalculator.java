package solutions.interview;

import java.util.Arrays;
import java.util.List;

public class SimpleCalculator {
    public static long calculate(String expression) {
        return calculate(expression, 0).get(0);
    }

    private static List<Integer> calculate(String expression, int index) {
        char operator = '+';
        int result = 0;

        while (index < expression.length()) {
            char currentCharacter = expression.charAt(index);

            if (currentCharacter == '+' || currentCharacter == '-') {
                operator = currentCharacter;
            } else {
                int value = 0;

                if (Character.isDigit(currentCharacter)) {
                    value = Character.getNumericValue(currentCharacter);
                } else if (currentCharacter == '(') {
                    List<Integer> valueIndex = calculate(expression, index);
                    value = valueIndex.get(0);
                    index = valueIndex.get(1);
                }

                if (operator == '+') {
                    result += value;
                }

                if (operator == '-') {
                    result -= value;
                }
            }

            index += 1;
        }

        return Arrays.asList(result, index);
    }
}
