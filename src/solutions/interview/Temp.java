package solutions.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        System.out.println(sparseArrays(Arrays.asList("4", "aba", "baba", "aba", "xzxb"), Arrays.asList("3", "aba", "xzxb", "ab")));
        System.out.println(findMedian(Arrays.asList(0, 1, 2, 4, 6, 5, 3)));
        System.out.println(lonelyInteger(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
        System.out.println("Is Palindrome: " + isPalindrome(11));
        System.out.println("Grades: " + gradingStudents(new ArrayList(Arrays.asList(73, 67, 38, 33))));
    }

    public static List<Integer> sparseArrays(List<String> strings, List<String> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (String word : strings) {
            map.merge(word, 1, Integer::sum);
        }

        for (String query : queries) {
            results.add(map.getOrDefault(query, 0));
        }

        return results;
    }

    public static int findMedian(List<Integer> arr) {
        List<Integer> sortedArr = arr.stream().sorted().toList();
        return sortedArr.get(sortedArr.size() / 2);
    }

    public static int lonelyInteger(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer number : arr) {
            map.merge(number, 1, Integer::sum);

            if (map.get(number) >= 2) {
                map.remove(number);
            }
        }

        for (Integer lonelyInteger : map.keySet()) {
            return lonelyInteger;
        }

        return 0;
    }

    public static boolean isPalindrome(int num) {
        if(num < 0) return  false;

        int reversed = 0, remainder, original = num;

        while (num != 0) {
            remainder = num % 10; // Remainder integer is stored in variable.
            reversed = reversed * 10 + remainder; // Multiply reversed by 10 then add the remainder, so it gets stored at next decimal place.
            num /= 10;  // The last digit is removed from num after division by 10.
        }

        return original == reversed;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (Integer grade : grades) {
            int remainder = grade % 10;

            if (grade < 38 || remainder == 0 || remainder == 5) {
                roundedGrades.add(grade);
            } else {
                if (remainder < 5 && 5 - remainder < 3) {
                    grade = grade + (5 - remainder);
                } else if (10 - remainder < 3) {
                    grade = grade + (10 - remainder);
                }

                roundedGrades.add(grade);
            }
        }

        return roundedGrades;
    }
}
