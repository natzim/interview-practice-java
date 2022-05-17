package solutions.interview;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String text) {
        Stack<Character> stack = new Stack<>();
        char[] parentheses = text.toCharArray();

        for (char parenthesis : parentheses) {
            if (!stack.isEmpty()) {
                switch (parenthesis) {
                    case '}' -> { if (stack.peek() == '{') { stack.pop(); continue; }}
                    case ')' -> { if (stack.peek() == '(') { stack.pop(); continue; }}
                    case ']' -> { if (stack.peek() == '[') { stack.pop(); continue; }}
                }
            }

            stack.push(parenthesis);
        }

        return stack.isEmpty();
    }
}
