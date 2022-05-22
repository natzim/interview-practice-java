package solutions.interview;

public class StringInsideString {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        haystack:
        for (int hIndex = 0; hIndex < haystack.length(); hIndex++) {
            if (haystack.charAt(hIndex) == needle.charAt(0)) {
                for (int nIndex = 1; nIndex < needle.length(); nIndex++) {
                    int currentHIndex = hIndex + nIndex;

                    if (currentHIndex >= haystack.length()) {
                        break haystack;
                    }

                    if (haystack.charAt(currentHIndex) != needle.charAt(nIndex)) {
                        continue haystack;
                    }
                }

                return hIndex;
            }
        }

        return -1;
    }
}
