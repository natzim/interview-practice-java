package solutions.interview;

public class CamelCase {
    public static String convertCamelCase(String action) {
        String[] splitAction = action.split(";");

        if (splitAction.length == 3) {
            if (splitAction[0].charAt(0) == 'S') {
                return split(splitAction[2]);
            } else if (splitAction[0].charAt(0) == 'C') {
                return combine(splitAction[1].charAt(0), splitAction[2]);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String split(String text) {
        return String.join(" ", text.split("(?<!^)(?=[A-Z])")).replace('(', ' ').replace(')', ' ').trim().toLowerCase();
    }

    public static String combine(char type, String text) {
        String output;
        String[] splitText = text.split(" ");

        for (int index = 0; index < splitText.length; index++) {
            if ((type == 'V' || type == 'M') && index == 0) continue;

            String word = splitText[index];
            splitText[index] = (char)(word.charAt(0) - 32) + word.substring(1);
        }

        output = String.join("", splitText);
        return output + ((type == 'M') ? "()" : "");
    }
}
