package solutions.interview;

import java.util.Hashtable;
import java.util.List;

public class RansomNote {
    private final Hashtable<Character, Integer> availableChars;

    public RansomNote(List<Character> characters) {
        availableChars = new Hashtable<>();

        // Setup hashtable.
        characters.forEach(c -> {
            availableChars.merge(c, 1,Integer::sum);

            if (availableChars.containsKey(c)) {
                availableChars.replace(c.toString().toLowerCase().charAt(0), availableChars.get(c) + 1);
            } else {
                availableChars.put(c, 1);
            }
        });
    }

    public boolean CanSpell(String message) throws IllegalArgumentException {
        if (message == null || message.length() == 0) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }

        for (Character c: message.toLowerCase().toCharArray()) {
            if (!availableChars.containsKey(c)) {
                return false;
            }
        }

        return true;
    }
}
