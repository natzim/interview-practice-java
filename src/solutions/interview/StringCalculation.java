package solutions.interview;

import java.util.Stack;

public class StringCalculation {
    public static int calculateString(String calculation) {
        int numberCounter = 0;
        boolean performOperation = false;

        Stack<String> calculations = new Stack<>();

        for (int index = 0; index < calculation.length(); index++) {
            if (calculation.charAt(index) == '+' || calculation.charAt(index) == '-' || calculation.charAt(index) == '*' || calculation.charAt(index) == '/') {
                calculations.push(calculation.substring(index - numberCounter, index));

                if (performOperation) {
                    calculations.push(String.valueOf(performMathOperation(Integer.parseInt(calculations.pop()), calculations.pop(), Integer.parseInt(calculations.pop()))));
                    performOperation = false;
                }

                calculations.push(calculation.substring(index, index + 1));
                numberCounter = 0;

                if (calculation.charAt(index) == '*' || calculation.charAt(index) == '/') {
                    performOperation = true;
                }
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

    private static int performMathOperation(int num2, String operation, int num1) {
        return switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }
}
