package Easy;

/**
 * Created by yuwang on 6/15/16.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) return 0;
        int i = 0;
        int j = A.length;
        while (i < j) {
            if (A[i] == elem) {
                A[i] = A[j - 1]; // move last element
                j--; // decrease length
            } else i++; // move on
        }
        return j;
    }
}
