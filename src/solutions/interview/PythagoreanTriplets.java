package solutions.interview;

import java.util.HashSet;
import java.util.List;

public class PythagoreanTriplets {
    public static boolean findPythagoreanTriplets(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer number: numbers) {
            set.add(number * number);
        }

        for (Integer a: numbers) {
            for (Integer b : numbers) {
                if (set.contains(a * a + b * b)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean findPythagoreanTripletsBrute(List<Integer> numbers) {
        for (Integer a: numbers) {
            for (Integer b: numbers) {
                for (Integer c: numbers) {
                    if (a*a + b*b == c*c) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
