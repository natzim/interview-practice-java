package solutions.interview;

public class FirstLastIndices {
    public static int[] findIndices(int[] numbers, int target) {
        int first = binarySearchIterative(numbers, 0, numbers.length - 1, target, true);
        int last = binarySearchIterative(numbers, 0, numbers.length -1 , target, false);

        return new int[] {first, last};
    }

    private static int binarySearchRecursive(int[] numbers, int low, int high, int target, boolean findFirst) {
        if (high < low) {
            return -1;
        }

        int mid = (high + low) / 2;

        if (findFirst) {
            if ((mid == 0 || target > numbers[mid - 1]) && target == numbers[mid]) {
                return mid;
            }

            if (target > numbers[mid]) {
                return binarySearchRecursive(numbers, mid + 1, high, target, findFirst);
            } else {
                return binarySearchRecursive(numbers, low, mid - 1, target, findFirst);
            }
        } else {
            if ((mid == numbers.length - 1 || target < numbers[mid + 1]) && numbers[mid] == target) {
                return mid;
            }

            if (target < numbers[mid]) {
                return binarySearchRecursive(numbers, low, mid - 1, target, findFirst);
            } else {
                return binarySearchRecursive(numbers, mid + 1, high, target, findFirst);
            }
        }
    }

    private static int binarySearchIterative(int[] numbers, int low, int high, int target, boolean findFirst) {
        while (true) {
            if (high < low) {
                return -1;
            }

            // Find middle of the array.
            int mid = (high + low) / 2;

            // Find indices.
            if (findFirst) {
                if ((mid == 0 || target > numbers[mid - 1]) && numbers[mid] == target) {
                    return mid;
                }

                if (target > numbers[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if ((mid == numbers.length - 1 || target < numbers[mid + 1]) && numbers[mid] == target) {
                    return mid;
                }

                if (target < numbers[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
    }
}
