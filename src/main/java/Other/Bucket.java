/**
 * Created by yuwang on 6/30/16.
 */

package Other;

public class Bucket {

    public static int[] sort(int[] array) {


        if (array == null || array.length <= 1) return array;

        int[] temp = new int[10000];

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            temp[array[i]]++;
        }

        int j = 0;
        for (int i = 0; i < temp.length; i++) {

            if (temp[i] > 0) {


                while (temp[i] > 0) {
                    result[j] = i;
                    temp[i]--;
                    j++;


                }

            }

        }

        return result;

    }

    public static void main(String[] argus) {

        int[] test = {1, 43, 2, 3, 6, 2, 1, 3, 55, 2, 3, 543, 2, 4};


        for (int i = 0; i < test.length; i++) {
            System.out.print(sort(test)[i] + " ");
        }


    }


}
