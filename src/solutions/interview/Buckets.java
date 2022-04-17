package solutions.interview;

public class Buckets {
    public static int bucketCounter(int coins) {
        int bucketCounter = 1;

        while(true) {
            if (((bucketCounter * (bucketCounter + 1)) / 2) >= coins) {
                return bucketCounter;
            } else {
                bucketCounter++;
            }
        }
    }
}
