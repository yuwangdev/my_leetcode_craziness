package Easy;

/**
 * Created by yuwang on 6/19/16.
 */
public class PalindromNumber {

    public static boolean isPalindrom(int num) {
        if (num < 0) return false;
        /*find the most significant digit*/
        int div = 1;
        while (num / div >= 10) div *= 10; // two digits

        while (num != 0) { // stop till num is 0, all digits compared
            int l = num / div; // left digit
            int r = num % 10; // right digit
            if (l != r) return false; // compare
            num = (num % div) / 10; // remove first and last digit
            div /= 100; // div should be smaller
        }
        return true;
    }
}
