package Easy;

/**
 * Created by yuwang on 6/15/16.
 */
public class ATOI {
    public static int atoi(String str) {
        /*validate input*/
        if (str == null || str.length() == 0) return 0;
        long longRes = 0; // result can be out of range
        /*whitespaces*/
        str = str.trim(); // remove front and trailing whitespaces
        /*sign*/
        boolean neg = false; // is negative or not
        if (str.charAt(0) == '-') {
            neg = true;
            str = str.substring(1, str.length());
        } else if (str.charAt(0) == '+') {
            str = str.substring(1, str.length());
        }
        /*calculation*/
        int i = 0;
        while (i < str.length()) { // calculate without sign
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                longRes = longRes * 10 + (c - '0');
            } else break; // break when not a digit
            i++;
        }
        longRes = neg ? longRes * (-1) : longRes; // add sign
        /*out of range*/
        if (longRes > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (longRes < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) longRes;
    }
}
