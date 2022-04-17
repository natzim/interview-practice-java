package solutions.interview;

public class Fibonacci {
    public static Integer fib(Integer n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib (n - 2);
    }

    public static Integer fibWithMemoization(Integer n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }

        int result;

        if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = fib (n - 1) + fib (n - 2);
        }

        memo[n] = result;
        return result;
    }

    public static Integer fibWithBottomUp(Integer n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        Integer[] fibNumbers = new Integer[n + 1];
        fibNumbers[1] = 1;
        fibNumbers[2] = 1;

        for (int index = 3; index <= n; index++) {
            fibNumbers[index] = fibNumbers[index - 1] + fibNumbers[index - 2];
        }

        return fibNumbers[n];
    }
}
