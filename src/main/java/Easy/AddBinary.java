package Easy;

/**
 * Created by yuwang on 7/1/16.
 */
public class AddBinary {

    public static String myOwnSolution(String str1, String str2) {

        String longer = (str1.length() <= str2.length()) ? str2 : str1;
        String shorter = (str1.length() <= str2.length()) ? str1 : str2;
        int longerLen = longer.length();
        int shorterLen = shorter.length();

        int i = shorter.length() - 1;
        int diff = longerLen - shorterLen;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i > 0) {

            if (shorter.charAt(i) + longer.charAt(i + diff) + carry < 2) {
                result.append(shorter.charAt(i) + longer.charAt(i + diff) + carry);
                carry = 0;
            }

            if (shorter.charAt(i) + longer.charAt(i + diff) + carry == 2) {
                result.append(0);
                carry = 1;
            }

            if (shorter.charAt(i) + longer.charAt(i + diff) + carry == 3) {
                result.append(1);
                carry = 1;
            }

            i--;

        }

        while (diff > 0) {

            if (longer.charAt(diff - 1) + carry == 2) {
                result.append(0);
                carry = 1;
            }

            if (longer.charAt(diff - 1) + carry < 2) {
                result.append(longer.charAt(diff - 1) + carry);
                carry = 0;
            }

            diff--;

        }

        return result.reverse().toString();


    }


}



