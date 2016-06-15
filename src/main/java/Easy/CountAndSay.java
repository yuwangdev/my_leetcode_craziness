package Easy;

/**
 * Created by yuwang on 6/12/16.
 */
public class CountAndSay {


    public static String countAndSay(int n) {
        String res = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] prev = res.toCharArray();
            for (int i = 0; i < prev.length; i++) {
                int count = 1; // initialize current count as 1
                while (i + 1 < prev.length && prev[i] == prev[i + 1]) {
                    count++; // search for same char
                    i++;
                }
                sb.append(count).append(prev[i]);
            }
            res = sb.toString();
        }
        return res;
    }


    public static String mySolution(int n) {

        if (n == 1) return "11";
        if (n == 2) return "21";

        char[] prevResult = mySolution(n - 1).toCharArray();

        StringBuilder result = new StringBuilder();

        int index = 0;

        while (index < prevResult.length) {

            int counter = 1;

            while (index + 1 < prevResult.length && prevResult[index] == prevResult[index + 1]) {
                counter++;
                index++;
            }

            result.append(counter).append(prevResult[index]);


        }

        return result.toString();


    }


}
