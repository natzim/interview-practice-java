package TwoRansomNote;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class RansomNote {

    public boolean canSpell(String word, char[] availableChars) {
        char[] wordChars = word.toCharArray();

        for (char wordChar :
                wordChars) {
            for (int i = 0; i < availableChars.length; i++) {
                if (wordChar == availableChars[i]) {
                    break;
                } else if (i == availableChars.length - 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
