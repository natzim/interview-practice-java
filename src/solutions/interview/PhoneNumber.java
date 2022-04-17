package solutions.interview;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PhoneNumber {
    public static String phoneNumberAnalyzer(String number) {
        try {
            List<String> numberSplit = Arrays.asList(number.split("-"));

            if (numberSplit.size() > 0) {
                // Check for area code 101.
                String areaCode = numberSplit.get(0);
                if (areaCode.equals("101")) {
                    return "101 Area Code";
                }

                // Check if area code adds up to 5.
                AtomicInteger areaCodeCount = new AtomicInteger();
                //areaCode.chars().mapToObj(c -> (char) c).toList().forEach(c -> areaCodeCount.addAndGet(Integer.parseInt(c.toString())));
                areaCode.chars().mapToObj(c -> (char) c).forEach(c -> areaCodeCount.addAndGet(Integer.parseInt(c.toString())));

                int areaCodeCount2 = 0;
                for(Character c: areaCode.toCharArray()) {
                    areaCodeCount2 += Integer.parseInt(c.toString());
                }

                if (areaCodeCount.get() == 5) {
                    return "Area code = 5";
                }

                // Check if all digits are prime numbers.
                for (char c: number.toCharArray()) {
                    if (c == '-') continue;

                    if (!BigInteger.valueOf(Character.getNumericValue(c)).isProbablePrime(100)) {
                        break;
                    }

                    if (number.charAt(number.length() - 1) == c) {
                        return "Is Prime";
                    }
                }

                // Return default message.
                return "Default Number";
            } else {
                throw new Exception("Invalid phone number.");
            }
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
