package Easy;

/**
 * Created by yuwang on 7/1/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sqr = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if ((row[i] & 1 << num) > 0) return false; // already in row
                    else row[i] |= 1 << num;

                    if ((col[j] & 1 << num) > 0) return false;// already in col
                    else col[j] |= 1 << num;

                    int sqrIdx = (i - i % 3) + j / 3; // note the square idx
                    if ((sqr[sqrIdx] & 1 << num) > 0) return false; // already
                    else sqr[sqrIdx] |= 1 << num;

                }
            }
        }
        return true;

    }


}
