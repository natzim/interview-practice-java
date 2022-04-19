package solutions.interview;

import java.util.Stack;

public class StringCalculation {
    public static int calculateString(String calculation) {
        int numberCounter = 0;
        boolean performOperation = false;
        boolean performPower = false;

        Stack<String> calculations = new Stack<>();

        for (int index = 0; index < calculation.length(); index++) {
            if (calculation.charAt(index) == '+' || calculation.charAt(index) == '-' || calculation.charAt(index) == '*' || calculation.charAt(index) == '/' || calculation.charAt(index) == '^') {
                // Push found number onto stack.
                calculations.push(calculation.substring(index - numberCounter, index));

                if (calculation.charAt(index) == '^') {
                    performPower = true;
                } else if (performPower) {
                    calculations.push(String.valueOf(performMathOperation(Integer.parseInt(calculations.pop()), calculations.pop(), Integer.parseInt(calculations.pop()))));
                    performPower = false;
                }

                if (calculation.charAt(index) == '*' || calculation.charAt(index) == '/') {
                    performOperation = true;
                } else if (performOperation && !performPower) {
                    calculations.push(String.valueOf(performMathOperation(Integer.parseInt(calculations.pop()), calculations.pop(), Integer.parseInt(calculations.pop()))));
                    performOperation = false;
                }

                // Push calculation onto stack.
                calculations.push(calculation.substring(index, index + 1));
                numberCounter = 0;
            } else {
                if (index == calculation.length() - 1) {
                    calculations.push(calculation.substring(index - numberCounter, index + 1));
                } else {
                    numberCounter++;
                }
            }
        }

        while (true) {
            calculations.push(String.valueOf(performMathOperation(Integer.parseInt(calculations.pop()), calculations.pop(), Integer.parseInt(calculations.pop()))));

            if (calculations.size() == 1) {
                return Integer.parseInt(calculations.pop());
            }
        }
    }

    public static int calculateString(String[] calculation) {
        Stack<Integer> numbers = new Stack<>();

        for (String value : calculation) {
            try {
                Integer number = Integer.parseInt(value);
                numbers.push(number);
            } catch (Exception ex) {
                if (numbers.size() > 1) {
                    numbers.push(performMathOperation(numbers.pop(), value, numbers.pop()));
                } else {
                    return 0;
                }
            }
        }

        return numbers.pop();
    }

    private static int performMathOperation(int num2, String operation, int num1) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "^" -> (int) Math.pow(num1, num2);
            default -> 0;
        };
    }
}
