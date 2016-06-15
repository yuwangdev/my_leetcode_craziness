package Easy;

/**
 * Created by yuwang on 6/13/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String word = strs[0];
        int prefixLength = word.length();

        for (int i = 1; i < strs.length; ++i) {
            String nextWord = strs[i];
            prefixLength = Math.min(prefixLength, nextWord.length());
            for (int j = 0; j < prefixLength; ++j)
                if (word.charAt(j) != nextWord.charAt(j)) {
                    prefixLength = j;
                    break;
                }
        }

        return word.substring(0, prefixLength);
    }


    public String myOwnSoluiton(String[] s) {

        if (s.length == 0) return null;
        if (s.length == 1) return s[0];

        String firstWord = s[0];
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (j < firstWord.length()) {
            char current = firstWord.charAt(j);
            Boolean flag = true;

            for (String string : s) {
                if (j < string.length()) {

                    if (string.charAt(j) != current) {
                        flag = false;
                    }

                } else {
                    flag = false;
                }

            }

            if (flag) stringBuilder.append(current);

        }
        return stringBuilder.toString();

    }
}
