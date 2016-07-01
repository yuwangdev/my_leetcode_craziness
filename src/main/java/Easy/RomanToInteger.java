package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuwang on 6/30/16.
 */
public class RomanToInteger {
    public int romanToInt(String s) {

        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> mapping = new HashMap<Character, Integer>();

        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int length = s.length();
        int result = mapping.get(s.charAt(length - 1));

        for (int i = length - 2; i >= 0; i--) { // backwards
            if (mapping.get(s.charAt(i + 1)) <= mapping.get(s.charAt(i)))
                result += mapping.get(s.charAt(i));
            else
                result -= mapping.get(s.charAt(i));
        }
        return result;
    }
}
