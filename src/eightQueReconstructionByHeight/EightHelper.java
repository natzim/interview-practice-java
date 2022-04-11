package eightQueReconstructionByHeight;

import java.util.*;

public class EightHelper {

    public ArrayList<int[]> sortByHeight(int[][] values) {
        Arrays.sort(values, Comparator.comparingInt((int[] a) -> a[1]));
        Arrays.sort(values, Comparator.comparingInt((int[] a) -> -a[0]));

        ArrayList<int[]> result = new ArrayList<>();

        for (int[] value:
             values)  {
            result.add(value[1], value);
        }

        return result;
    }

    public void arrangeCoins(List<Long> coins) {
        Hashtable<Long, Long> coinsToStairs = new Hashtable<>();
        Long mostCoins = Collections.max(coins);

        Long numberOfCoins = 1L;
        Long stairs = 1L;
        while (numberOfCoins <= mostCoins) {
            Long newNumberOfCoins = stairs * (stairs + 1) / 2;
            while (numberOfCoins < newNumberOfCoins) {
                coinsToStairs.put(numberOfCoins, stairs - 1);
                numberOfCoins++;
            }
            coinsToStairs.put(numberOfCoins, stairs);
            stairs ++;
        }

        for (Long coin : coins) {
            System.out.println(coinsToStairs.get(coin));
        }
    }

    public void arrangeCoins3(List<Long> coins) {
        Hashtable<Long, Long> stairsToCoins = new Hashtable<>();
        Long mostCoins = Collections.max(coins);

        long numberOfCoins = 1L;
        long stairs = 1L;
        while (numberOfCoins <= mostCoins) {
            numberOfCoins = stairs * (stairs + 1) / 2;
            stairsToCoins.put(stairs, numberOfCoins);
            stairs ++;
        }

        for (Long coin : coins) {
            long numberOfBuckets = 0;
            while (true) {
                numberOfBuckets++;
                long neededCoin = stairsToCoins.get(numberOfBuckets);
                if (neededCoin > coin) {
                    System.out.println(numberOfBuckets - 1);
                    break;
                }
            }
        }
        /*
         Ran out of time, but should've sorted min to max storing the original index.
         That
         */
    }

    public void arrangeCoins2(List<Long> coins) {
        for (Long coin:
             coins) {
            int stairs = 1;
            int coinsForStairs = 1;
            while (coinsForStairs <= coin) {
                stairs++;
                coinsForStairs = stairs * (stairs + 1) / 2;
            }

            System.out.println(stairs - 1);
        }
    }

    public String parseDistrict(String phonenum) {
        String[] phoneSplit = phonenum.split("-");
        String areaCode = phoneSplit[0];

        if (areaCode.equals("101")) {
            return "Mystic";
        }

        char[] areaCodeSplit = areaCode.toCharArray();
        int total = 0;
        for (char numberChar:
                areaCodeSplit) {
            String numberStr = "" + numberChar;
            total += Integer.parseInt(numberStr);
        }

        if (total == 5) {
            return "Valor";
        }

        boolean isPrime = true;
        outerLoop:
        for (String numSplit:
                phoneSplit) {
            for (char numberChar:
                    numSplit.toCharArray()) {
                String numberStr = "" + numberChar;
                isPrime = isPrime(Integer.parseInt(numberStr));
                if (!isPrime) {
                    break outerLoop;
                }
            }
        }
        if (isPrime) {
            return "Forbidden";
        } else {
            return "Instinct";
        }

    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public boolean isValidSudoku(List<List<Integer>> puzzle) {
        // Number of rows is less than 7.
        if (puzzle.size() > 6) return false;

        for (int i = 0; i < puzzle.size(); i++) {
            // Number of columns is less than 7 and equal to the number of rows.
            if (puzzle.get(i).size() > 6 || puzzle.get(i).size() != puzzle.size()) return false;

            if (hasNoCommonDivisors(puzzle.get(i))) return false;
            List<Integer> column = new ArrayList<>();
            for (int j = 0; j < puzzle.size(); j++) {
                column.add(puzzle.get(i).get(j));
            }
            if (hasNoCommonDivisors(column)) return false;
        }

        return true;
    }

    public boolean hasNoCommonDivisors(List<Integer> list) {
        int minValue = Collections.min(list);
        int commonDivisor = 2;
        while (commonDivisor <= minValue) {
            for (int i = 0; i < list.size(); i++) {
                // Value is less than 100.
                if (list.get(i) > 0 && list.get(i) > 99) {
                    return false;
                } else if (list.get(i) % commonDivisor != 0) {
                    commonDivisor++;
                    break;
                } else if (i == list.size() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasNoCommonDivisors2(List<Integer> list) {
        if (list != null && list.size() > 0) {
            int minValue = Collections.min(list);

            divisorLoop:
            for (int index = 2; index <= minValue; index++) {
                for (int number : list) {
                    if (number % index != 0) {
                        continue divisorLoop;
                    }
                }

                return false;
            }
        }

        return true;
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0);
    }


    private int search(int[] nums, int target, int indexOffset) {
        int midIndex = (nums.length / 2);

        if (nums.length == 0 || nums.length == 1 && nums[0] != target) {
            return -1;
        } else if (nums[midIndex] < target) {
            nums = Arrays.copyOfRange(nums, midIndex, nums.length);
            return search(nums, target, indexOffset + midIndex);
        } else if (nums[midIndex] > target) {
            nums = Arrays.copyOfRange(nums, 0, midIndex);
            return search(nums, target, indexOffset);
        } else {
            return midIndex + indexOffset;
        }
    }
}
