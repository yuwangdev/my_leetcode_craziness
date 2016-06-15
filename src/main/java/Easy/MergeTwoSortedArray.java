package Easy;

/**
 * Created by yuwang on 6/13/16.
 */
public class MergeTwoSortedArray {

    private void merge(int A[], int m, int B[], int n) {
        if (n == 0) return;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        /*still elements in B*/
        while (n > 0) A[n - 1] = B[n-- - 1];
    }


    public void mergeTwoSortedArray(int A[], int m, int B[], int n) {
        // m and n are the length of A and B
        if (A == null || B == null) return;

        int newLength = m + n - 1;

        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {

            if (A[i] >= B[j]) {
                A[newLength--] = A[i--];

            } else {
                A[newLength--] = B[j--];


            }

//            A[newLength--] = A[i] >= B[j] ? A[i--] : B[j--];


        }

        while (j >= 0) {
            A[newLength--] = B[j--];


        }


    }
}
