package sixPermutations;

import java.sql.Array;
import java.util.ArrayList;

public class Permutations {

    public ArrayList<int[]> getPermutations(int[] original) {
        return getPermutations(original, 0);
    }

    private ArrayList<int[]> getPermutations(int[] original, int startIndex) {
        ArrayList<int[]> result = new ArrayList<>();

        if (startIndex == original.length - 1) {
            result.add(original.clone());
        } else {
            for (int i = startIndex; i < original.length; i++) {
                swapElements(original, startIndex, i);
                result.addAll(getPermutations(original, startIndex + 1));
                swapElements(original, i, startIndex);
            }
        }

        return result;
    }

    private void swapElements(int[] array, int index1, int index2) {
        int valueTemp = array[index1];
        array[index1] = array[index2];
        array[index2] = valueTemp;
    }

}
