package solutions.interview;

import java.util.Hashtable;

public class Testing {
    public static void main(String[] args) {
        System.out.println(LetterCapitalize("i ran there"));
        System.out.println(DashInsert("454793"));
        System.out.println(DistinctList(new int[] {100,2,101,4}));
    }

    public static String LetterCapitalize(String str) {
        String[] words = str.split(" ");

        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            words[index] = (char)(word.charAt(0) - 32) + word.substring(1);
        }

        return String.join(" ", words);
    }

    public static String DashInsert(String str) {
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

    public static int DistinctList(int[] arr) {
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
