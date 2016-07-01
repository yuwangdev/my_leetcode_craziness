package Easy;

/**
 * Created by yuwang on 7/1/16.
 */
public class NumberOfOneInBit {


    public static int numberOfOneInBit(int number) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            System.out.println(number >> i);

            if ((number >> i & 1) == 1) result++;

        }

        return result;


    }

    public static void main(String[] arugs) {

        System.out.println(numberOfOneInBit(13));


    }


}
