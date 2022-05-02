package solutions.interview;

import java.util.HashMap;
import java.util.List;

public class DivisibleSumPairs {
    public static int divisibleCounter(int size, int divider, List<Integer> numbers) {
        int counter = 0;

        for (int index = 0; index < numbers.size(); index++) {
            for (int index2 = index + 1; index2 < numbers.size(); index2++) {
                if ((numbers.get(index) + numbers.get(index2)) % divider == 0) {
                    counter++;
                }
            }
        }

        return counter;
    }

    /**
     * Two numbers are divisible by k means the remainders of the two numbers are individually divisible by k.
     * Maintain a map containing remainders and everytime a complement of remainder is found increment the count.
     * @param size Size of the list.
     * @param divider The dividing number.
     * @param numbers List of numbers.
     * @return Counter on how many pairs we found.
     */
    public static int divisibleCounterFast(int size, int divider, List<Integer> numbers) {
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer number : numbers) {
            int remainder = number % divider;
            int pairRemainder = (divider - remainder) % divider;

            counter += map.getOrDefault(pairRemainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return counter;
    }
}
