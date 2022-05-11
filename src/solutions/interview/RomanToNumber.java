package solutions.interview;

import java.util.HashMap;
import java.util.Optional;

public class RomanToNumber {
    public static int translateRomanToNumber(String romanNumeral) {
        int result = 0;

        for (int index = 0; index < romanNumeral.length(); index++) {
            char numeral = romanNumeral.charAt(index);
            char previousNumeral = index != 0 ? romanNumeral.charAt(index - 1) : '_';

            switch (numeral) {
                case 'I' -> result += 1;
                case 'V' -> result += previousNumeral == 'I' ? 3 : 5;
                case 'X' -> result += previousNumeral == 'I' ? 8 : 10;
                case 'L' -> result += previousNumeral == 'X' ? 30 : 50;
                case 'C' -> result += previousNumeral == 'X' ? 80 : 100;
                case 'D' -> result += previousNumeral == 'C' ? 300 : 500;
                case 'M' -> result += previousNumeral == 'C' ? 800 : 1000;
            }
        }

        return result;
    }
}
