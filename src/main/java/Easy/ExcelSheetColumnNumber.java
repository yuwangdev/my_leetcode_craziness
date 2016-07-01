package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {

        if (s == null || s.length() == 0) return 0;

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }


}
