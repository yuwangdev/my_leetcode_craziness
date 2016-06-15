package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by yuwang on 6/13/16.
 */
public class LongestSubstringWithoutRepeatingChar {


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           // start: the pointer at the new substring without repeating chars
            start = Math.max(start, (map.containsKey(c)) ? map.get(c) + 1 : 0);
            // max: current max length
            max = Math.max(max, i - start + 1);

            map.put(c, i);
        }
        return max;
    }


    public static int myOwnSolution(String s) {


        if (s.length() == 0 || s == null) return 0;
        if (s.length() == 1) return 1;

        HashSet<Character> hashSet = new HashSet();

        char[] chars = s.toCharArray();

        int counter = 0;

        for (char c : chars) {

            if (!hashSet.contains(c)) {
                hashSet.add(c);
                counter++;

            }


        }

        return counter;


    }
}



