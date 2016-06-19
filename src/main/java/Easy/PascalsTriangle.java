package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuwang on 6/19/16.
 */
public class PascalsTriangle {

    public List<List<Integer>> mySolution(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0) return null;


        mySolution(n, result);
        return result;

    }

    private void mySolution(int n, List<List<Integer>> result) {

        if (n == 0) return;
        if (n == 1) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            result.add(temp);

        }


        if (n > 1) {

            List<Integer> prevResult = result.get(n - 2);
            List<Integer> currentLineResult = new ArrayList<Integer>();
            currentLineResult.add(1);

            for (int i = 0; i < prevResult.size() - 1; i++) {


                currentLineResult.add(prevResult.get(i) + prevResult.get(i + 1));


            }

            currentLineResult.add(1);
            result.add(currentLineResult);

        }


    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) return triangle;

        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<Integer>(i + 1);

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
