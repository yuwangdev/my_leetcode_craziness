package Easy;

/**
 * Created by yuwang on 6/13/16.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int count = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            if (s.charAt(i) == ' ' && count != 0) return count;
        }
        return count;
    }
}
