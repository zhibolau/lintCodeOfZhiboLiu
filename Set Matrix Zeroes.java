Set Matrix Zeroes
把出现0的行跟列都设置成0
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.


Given a matrix

[
  [1,2],
  [0,3]
],
return
[
[0,2],
[0,0]
]



public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean emptyRow = false;
        boolean emptyCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {//此row若有0就把emptyRow设置成true
                emptyRow = true;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {//此col若有0就把emptyRow设置成true
                emptyCol = true;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {//若中间出现0 就把当前row col 的首元素设置成0 然后用下边的设置其他的位置
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {//第一个row 或 第一个col 出现0 就把当前row或col设置成0， 余下的对应col或row用 boolean来设置！
                    matrix[i][j] = 0;
                }
            }
        }
        if (emptyRow) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (emptyCol) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}


