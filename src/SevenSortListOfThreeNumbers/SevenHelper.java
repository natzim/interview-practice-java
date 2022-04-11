package SevenSortListOfThreeNumbers;

public class SevenHelper {

    public int[] sort(int[] numbers) {
        int oneBoundry = 0;
        int threeBoundry = numbers.length - 1;

        int i = 0;
        while (i < threeBoundry) {
            if (numbers[i] == 1) {
                swapElements(numbers, i, oneBoundry);
                oneBoundry += 1;
            } else if (numbers[i] == 3) {
                swapElements(numbers, i, threeBoundry);
                threeBoundry -= 1;

                continue;
            }

            i += 1;
        }

        return numbers;
    }

    private void swapElements(int[] array, int index1, int index2) {
        int valueTemp = array[index1];
        array[index1] = array[index2];
        array[index2] = valueTemp;
    }
}
