package FourTwoSum;

import java.util.Hashtable;

public class TwoSum {

    public int[] twoSum(int target, int[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (j <= i) continue;
                if (values[i] + values[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public int[] twoSumB(int target, int[] values) {
        Hashtable<Integer, Integer> valuesHT = new Hashtable<>();
        valuesHT.put(values[0], 0);

        for(int i = 1; i < values.length; i++) {
            if (valuesHT.containsKey(target - values[i])) {
                return new int[]{valuesHT.get(target-values[i]), i};
            } else {
                valuesHT.put(values[i], i);
            }
        }

        return new int[]{};
    }
}
