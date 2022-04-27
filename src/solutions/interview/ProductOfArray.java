package solutions.interview;

import java.util.HashMap;

public class ProductOfArray {
    public static int[] productOfArrayExceptSelf(int[] numbers) {
        int[] products = new int[numbers.length];

        HashMap<Integer, Integer> productsForward = new HashMap<>();
        HashMap<Integer, Integer> productsBackward = new HashMap<>();

        // {5, 2, 3, 4, 6}
        for (int indexForward = 0, indexBackward = numbers.length - 1; indexForward < numbers.length; indexForward++, indexBackward--) {
            if (indexForward == 0) {
                productsForward.merge(indexForward, numbers[indexForward], Integer::sum);
            } else {
                productsForward.merge(indexForward, numbers[indexForward] * productsForward.get(indexForward - 1), Integer::sum);
            }

            if (indexBackward == numbers.length - 1) {
                productsBackward.merge(indexBackward, numbers[indexBackward], Integer::sum);
            } else {
                productsBackward.merge(indexBackward, numbers[indexBackward] * productsBackward.get(indexBackward + 1), Integer::sum);
            }
        }

        for (int index = 0; index < numbers.length; index++) {
            if (index == 0) {
                products[index] = productsBackward.get(index + 1);
            } else if (index == numbers.length -1) {
                products[index] = productsForward.get(index - 1);
            } else {
                products[index] = productsForward.get(index - 1) * productsBackward.get(index + 1);
            }
        }

        return products;
    }
}
