package fiveFirstAndLastIndices;

public class FiveHelper {

    public int[] getFirstAndLastIndices(int target, int[] values) {
        int first = getFirstAndLastIndices(target, values, 0, values.length - 1, true);
        int second = getFirstAndLastIndices(target, values, 0, values.length - 1, false);

        return new int[]{first, second};
    }

    private int getFirstAndLastIndices(int target, int[] values, int low, int high, boolean findFirst) {
        int mid = (high - low) / 2 + low;

        if (findFirst) {
            if ((mid == 0 || values[mid - 1] < target) && values[mid] == target) {
                return mid;
            } else if (values[mid] < target) {
                return getFirstAndLastIndices(target, values, mid, high, true);
            } else {
                return getFirstAndLastIndices(target, values, low, mid, true);
            }
        } else {
            if ((mid == values.length - 1 || values[mid + 1] > target) && values[mid] == target) {
                return mid;
            } else if (values[mid] <= target) {
                return getFirstAndLastIndices(target, values, mid, high, false);
            } else {
                return getFirstAndLastIndices(target, values, low, mid, false);
            }
        }
    }
}
