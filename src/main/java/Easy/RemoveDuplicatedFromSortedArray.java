package Easy;

/**
 * Created by yuwang on 6/19/16.
 */
public class RemoveDuplicatedFromSortedArray {

    public static int countUnique(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;   // only count how many times two elements are duplicad
            }
        }
        return array.length - count;
    }

    public static int removeDuplicatesNaive(int[] array) {
        if (array.length < 2)
            return array.length;

        int i = 0;
        int j = i + 1;

        while (j < array.length) {
            if (array[j] == array[i]) {
                j++;
            } else {
                i++;
                array[i] = array[j];
                j++;
            }
        }

        return i + 1;
    }


    public static int myOnwSolution(int[] array) {

        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return 1;

        int i = 0;
        int j = 1;

        while (i < array.length - 1) {

            if (array[i] == array[i + 1]) {

                i++;


            } else {

                i++;
                j++;


            }


        }


        return j;
    }


    public static void main(String[] argus) {

        int[] test0 = {1, 2, 2};
        int[] test1 = {1, 1, 2, 2};
        int[] test2 = {1, 1, 2};
        System.out.println(myOnwSolution(test0));
        System.out.println(myOnwSolution(test1));
        System.out.println(myOnwSolution(test2));


    }


}
