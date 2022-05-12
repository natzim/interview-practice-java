package solutions.interview;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

public class Testing {
    public static void main(String[] args) {
        System.out.println(letterCapitalize("i ran there"));
        System.out.println(dashInsert("454793"));
        System.out.println(distinctList(new int[] {100,2,101,4}));
        System.out.println(arrows("^vv<v"));
        System.out.println(numbersMax(new int[] {3,8,2,3,3,2}));
        System.out.println(binaryToZero("111"));
        System.out.println(Arrays.toString(randomPlaylist(new String[] {"song1", "song2", "song3", "song4", "song5", "song6"})));
    }

    public static String[] randomPlaylist(String[] songs) {
        for (int index = 0; index < songs.length; index++) {
            Random random = new Random();
            int randomSongIndex = random.nextInt(index, songs.length);

            String temp = songs[randomSongIndex];
            songs[randomSongIndex] = songs[index];
            songs[index] = temp;
        }

        return songs;
    }

    public static int binaryToZero(String S) {
        try {
            BigInteger number = new BigInteger(S, 2);

            int operations = 0;

            do {
                // Check if it is odd number.
                if (number.remainder(BigInteger.valueOf(2)).intValue() == 0) {
                    number = number.divide(BigInteger.valueOf(2));
                } else {
                    number = number.subtract(BigInteger.valueOf(1));
                }

                operations++;
            } while(number.intValue() > 0);

            return operations;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static int numbersMax(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int biggestOccurrence = 0;

        for (int number : A) {
            map.merge(number, 1, Integer::sum);
        }

        for (int key : map.keySet()) {
            int value = map.get(key);

            if (value == key && value > biggestOccurrence) {
                biggestOccurrence = value;
            }
        }

        return biggestOccurrence;
    }

    public static int arrows(String arrows) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxArrow = 0;

        char[] arrowArray = arrows.toCharArray();

        for (char arrow : arrowArray) {
            map.merge(arrow, 1, Integer::sum);
            int arrowCounter = map.get(arrow);

            if (arrowCounter > maxArrow) {
                maxArrow = arrowCounter;
            }
        }

        return arrows.length() - maxArrow;
    }

    public static String letterCapitalize(String str) {
        String[] words = str.split(" ");

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            words[index] = (char)(word.charAt(0) - 32) + word.substring(1);
        }

        return String.join(" ", words);
    }

    public static String dashInsert(String str) {
        StringBuilder stringBuffer = new StringBuilder();
        char[] characters = str.toCharArray();

        for (int index = 0; index < characters.length; index++) {
            Character currentCharacter = characters[index];
            Character nextCharacter = index + 1 != characters.length ? characters[index + 1] : null;

            stringBuffer.append(currentCharacter);

            // Checking current character.
            if (Character.getNumericValue(currentCharacter) % 2 != 0) {
                // Number is odd, check next value.
                if (nextCharacter != null) {
                    if (Character.getNumericValue(nextCharacter) % 2 != 0) {
                        stringBuffer.append("-");
                    }
                }
            }
        }

        return stringBuffer.toString();
    }

    public static int distinctList(int[] arr) {
        Hashtable<Integer, Integer> numbers = new Hashtable<>();

        int duplicateCounter = 0;

        for (int number : arr) {
            numbers.merge(number, 1, Integer::sum);

            int currentDuplicate = numbers.get(number);
            if (currentDuplicate > duplicateCounter) {
                duplicateCounter = currentDuplicate;
            }
        }

        return duplicateCounter == 1 ? 0 : duplicateCounter;
    }
}
