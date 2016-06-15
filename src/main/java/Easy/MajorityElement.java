package Easy;

import java.util.Arrays;

/**
 * Created by yuwang on 6/13/16.
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        if (num.length == 1) {
            return num[0];
        }
        Arrays.sort(num);
        return num[num.length / 2];


    }
}



