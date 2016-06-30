package Easy;

import java.util.Stack;

/**
 * Created by yuwang on 6/30/16.
 */
public class ValidParentheses {
    public static boolean isValidB(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<Character> stk = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stk.isEmpty()) {
                stk.push(c);
            } else if (stk.peek() == '(' && c == ')') {
                stk.pop();
            } else if (stk.peek() == '[' && c == ']') {
                stk.pop();
            } else if (stk.peek() == '{' && c == '}') {
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }


    public static Boolean myOwnSolution(String string) {

        return myOwnSolution(string, '(', ')')
                && myOwnSolution(string, '[', ']')
                && myOwnSolution(string, '{', '}');

    }

    public static Boolean myOwnSolution(String string, char parentOfLeft, char parentOfRight) {

        if (string == null || string.length() == 0) return true;

        int counterOfLeft = 0;

        for (int i = 0; i < string.length(); i++) {

            if (counterOfLeft == 0 && string.charAt(i) == parentOfRight) return false;

            if (string.charAt(i) == parentOfLeft) counterOfLeft++;

            if (string.charAt(i) == parentOfRight) counterOfLeft--;

        }

        return counterOfLeft == 0;

    }
}
