package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder title = new StringBuilder();
        while (n > 0) { // n要减小1,因为z==26
            n--; // note the 1 offset
            int r = n % 26;
            title.insert(0, (char) ('A' + r));
            n = n / 26;
        }
        return title.toString();
    }


}
