package Easy;

/**
 * Created by yuwang on 6/30/16.
 */
public class PlusOne {

    public int[] plusOne(int[] number) {

        for (int i = number.length - 1; i >= 0; i--) {

            number[i] = 1 + number[i];

            if (number[i] == 10) {
                number[i] = 0;
            } else {
                return number;
            }
        }

        int[] ans = new int[number.length + 1];
        ans[0] = 1;

        for (int i = 1; i < number.length; i++) {
            ans[i] = 0;
        }

        return ans;
    }

    public static int[] myOwnSolution(int[] number) {

        if (number.length == 0 || number == null) return number;

        if (number.length == 1) {
            if (number[0] + 1 != 10) {
                int[] res = {number[0] + 1};
                return res;
            } else {
                int[] res = {1, 0};
                return res;
            }
        }

        int carry = 0;

        for (int i = number.length - 1; i >= 0; i--) {

            if (i == number.length - 1) {

                if (number[i] + 1 != 10) {
                    number[i] += 1;
                    return number;

                } else {

                    number[i] = 0;
                    carry = 1;
                }
            }

            if (i < number.length - 1) {

                if (number[i] + carry != 10) {
                    number[i] += carry;
                    carry = 0;

                } else {

                    number[i] = 0;
                    carry = 1;
                }

            }
        }

        if (carry == 0) return number;

        int[] answer = new int[number.length + 1];

        answer[0] = 1;
        for (int i = 0; i < number.length; i++) answer[i + 1] = 0;
        return answer;


    }

}
