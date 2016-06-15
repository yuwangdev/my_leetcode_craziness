package Easy;

/**
 * Created by yuwang on 6/12/16.
 */
public class FactorialTrailingZeros {
    public static int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n; // add # of 5 in n
        }
        return r;
    }

}
