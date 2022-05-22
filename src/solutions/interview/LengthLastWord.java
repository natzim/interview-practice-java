package solutions.interview;

public class LengthLastWord {
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public static int lengthOfLastWordFaster(String s) {
        int counter = 0;

        for (int index = s.length() -1; index > -1; index--) {
            if (s.charAt(index) == ' ' && counter == 0) {
                continue;
            } else if (s.charAt(index) != ' ') {
                counter++;
            } else {
                break;
            }
        }

        return counter;
    }
}
