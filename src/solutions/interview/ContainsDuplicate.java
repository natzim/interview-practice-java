package solutions.interview;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean hasDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int number : nums) {
            if (set.contains(number)) {
                return true;
            } else {
                set.add(number);
            }
        }

        return false;
    }
}
