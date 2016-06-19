package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuwang on 6/19/16.
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int k) {
        List<Integer> row = new ArrayList<Integer>(k + 1);
        row.add(1);
        for (int i = 1; i <= k; i++) { // repeat k times
            for (int j = i - 1; j >= 1; j--) { // do it backwards
                row.set(j, row.get(j - 1) + row.get(j));
            }
            row.add(1); // add 1 at the end
        }
        return row;
    }


    // 更类似的解法
    public List<Integer> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        if (numRows <= 0) return null;

        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(0);
            List<Integer> row = new ArrayList<Integer>(i + 1);

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.set(0, row);
        }
        return triangle.get(0);
    }
}
