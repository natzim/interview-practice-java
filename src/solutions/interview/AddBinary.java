package solutions.interview;

public class AddBinary {
    public static String sum(String a, String b) {
        StringBuilder output = new StringBuilder();
        char carry = '0';

        for (int i = a.length() - 1, j = b.length() - 1; i > -1 || j > -1; i--, j--) {
            StringBuilder digits = new StringBuilder();

            if (i > -1) {
                digits.append(a.charAt(i));
            } else {
                digits.append('0');
            }

            if (j > -1) {
                digits.append(b.charAt(j));
            } else {
                digits.append('0');
            }

            digits.append(carry);

            switch (digits.toString()) {
                case "000" -> output.insert(0, '0');
                case "011", "101", "110" -> { output.insert(0, '0'); carry = '1'; }
                case "100", "010", "001" -> { output.insert(0, '1'); carry = '0'; }
                case "111" -> { output.insert(0, '1'); carry = '1'; }
            }
        }

        if (carry == '1') {
            output.insert(0, '1');
        }

        return output.toString();
    }
}
