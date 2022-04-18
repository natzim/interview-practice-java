package amazonPractice;

import java.util.*;
import java.util.stream.Collectors;

public class StringCalculation {
    /**
     * Assumptions (clarify): Follows pemdas, operators are ()^*\/+-, input is always a good equation,
     * no negative integers, input numbers are all ints and no spaces.
     * @param calculation: String that is an arithmetic problem.
     * @return: String that is the result of the problem.
     */
    public String calculate(String calculation) {
        List<Character> calcChars = calculation.chars().mapToObj((i) -> (char) i).collect(Collectors.toList());
        return calculate(calcChars, CalculationType.PARENTHESIS);
    }

    private String calculate(List<Character> calculation, CalculationType calcType) {
        // Used for nested parenthesis.
        Deque<Integer> indexStack = new ArrayDeque<>();

        int currentIndex = 0;

        while (true) {
            char character = calculation.get(currentIndex);
            if (calcType == CalculationType.PARENTHESIS) {
                // Recursively solve the parts inside parenthesis.
                if (character == '(') {
                    indexStack.push(currentIndex);
                } else if (character == ')') {
                    int startIndex = indexStack.pop();
                    // Removes the parenthesis.
                    calculation.remove(currentIndex);
                    calculation.remove(startIndex);
                    // Will update calculation List.
                    calculate(calculation.subList(startIndex, currentIndex - 1), CalculationType.EXPONENT);
                    currentIndex = 0;
                }
                // Use multiply for multiply and divide, and add for add and subatract.
            } else if (calcType == CalculationType.EXPONENT && calculation.get(currentIndex) == '^' ||
                    calcType == CalculationType.Multiply && (calculation.get(currentIndex) == '*' || calculation.get(currentIndex) == '/') ||
                    calcType == CalculationType.ADD && (calculation.get(currentIndex) == '+' || calculation.get(currentIndex) == '-')) {
                performAndSaveCalculation(calculation, currentIndex, calcType);
            }

            currentIndex++;

            if (currentIndex >= calculation.size() - 1) {
                if (calcType == CalculationType.PARENTHESIS) {
                    return calculate(calculation, CalculationType.EXPONENT);
                } else if (calcType == CalculationType.EXPONENT) {
                    return calculate(calculation, CalculationType.Multiply);
                } else if (calcType == CalculationType.Multiply) {
                    return calculate(calculation, CalculationType.ADD);
                } else {
                    return charListToString(calculation);
                }
            }
        }
    }

    private void performAndSaveCalculation(List<Character> calculation, int currentIndex, CalculationType type) {
        NumWithIndex num1 = getNumberByOperator(calculation, currentIndex, true);
        NumWithIndex num2 = getNumberByOperator(calculation, currentIndex, false);
        List<Character> result = performMathOperation(num1.getNumber(), num2.getNumber(), type);

        calculation.subList(num1.getIndex(), num2.getIndex()).clear();
        calculation.addAll(num1.getIndex(), result);
    }

    private NumWithIndex getNumberByOperator(List<Character> chars, int index, boolean isBefore) {
        int iterableIndex = index;
        while (iterableIndex >= 0) {
            if (isBefore) {
                iterableIndex --;
            } else {
                iterableIndex++;
            }

            if (iterableIndex <= 0 && isBefore) {
                return new NumWithIndex(charListToString(chars.subList(0, index)), 0);
            } else if (iterableIndex == chars.size() - 1 && !isBefore) {
                return new NumWithIndex(charListToString(chars.subList(index + 1, iterableIndex + 1)), iterableIndex + 1);
            } else if (chars.get(iterableIndex) == '(' || chars.get(iterableIndex) == ')' || chars.get(iterableIndex) == '*' ||
                    chars.get(iterableIndex) == '/' || chars.get(iterableIndex) == '+' || chars.get(iterableIndex) == '-') {
                return new NumWithIndex(
                        charListToString(chars.subList((isBefore ? iterableIndex : index) + 1, isBefore ? index : iterableIndex)),
                        isBefore ? iterableIndex + 1 : iterableIndex
                );

            }
        }

        return new NumWithIndex("0", 0);
    }

    private List<Character> performMathOperation(String num1, String num2, CalculationType type) {
        int result;

        int int1 = Integer.parseInt(num1);
        int int2 = Integer.parseInt(num2);

        if (type == CalculationType.EXPONENT) {
            result = (int) Math.pow(int1, int2);
        } else if (type == CalculationType.Multiply) {
            result = int1 * int2;
        } else if (type == CalculationType.DIVIDE) {
            result = int1 / int2;
        } else if (type == CalculationType.ADD) {
            result = int1 + int2;
        } else {
            result = int1 - int2;
        }

        return Integer.toString(result).chars().mapToObj((i) -> (char) i).toList();
    }

    private enum CalculationType {
        PARENTHESIS, EXPONENT, Multiply, DIVIDE, ADD, SUBTRACT
    }

    private static class NumWithIndex {

        public NumWithIndex(String number, int index) {
            this.number = number;
            this.index = index;
        }

        String number;
        int index;

        public String getNumber() {
            return number;
        }

        public int getIndex() {
            return index;
        }
    }

    private String charListToString(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

}


