package Easy;

/**
 * Created by yuwang on 6/28/16.
 */
public class StrStr {
    public static String strStr(String haystack, String needle) {
        if ((haystack == null) || (needle == null)) {
            return null;
        }

        int lengthOfStack = haystack.length();
        int lengthOfNeedle = needle.length();

        if (lengthOfStack < lengthOfNeedle) {
            return null;
        }

        for (int i = 0; i <= lengthOfStack - lengthOfNeedle; i++) {
            if (haystack.substring(i, i + lengthOfNeedle).equals(needle)) {
                return haystack.substring(i);
            }
        }
        return null;
    }


    public static String myOwnSolution(String string, String target) {

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == target.charAt(0)) {

                Boolean flag = true;
                int j = 0;

                while (j < target.length()) {

                    if (string.charAt(i + j) != target.charAt(j)) {
                        flag = false;
                        break;

                    }
                    j++;

                }

                if (flag) return string.substring(i);

            }

        }

        return null;

    }


}
