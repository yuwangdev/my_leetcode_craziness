package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class ValidPanlindrome {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) if (Character.isLetterOrDigit(c)) sb.append(c);
        String copy = sb.toString().toLowerCase();
        int length = copy.length();
        for (int i = 0; i < length / 2; i++) {
            if (copy.charAt(i) != copy.charAt(length - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
