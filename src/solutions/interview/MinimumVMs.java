package solutions.interview;

import java.util.Hashtable;
import java.util.List;

public class MinimumVMs {
    public static int getMinimumRequiredVMs(List<int[]> jobs) {
        int minimumRequiredVMs = 0;

        Hashtable<Integer, Integer> times = new Hashtable<>();

        for (int[] job : jobs ) {
            int start = job[0];
            int end = job[1];

            for (int index = start; index < end; index++) {
                times.merge(index, 1, Integer::sum);

                if (times.get(index) > minimumRequiredVMs) {
                    minimumRequiredVMs++;
                }
            }
        }

        return minimumRequiredVMs;
    }
}
