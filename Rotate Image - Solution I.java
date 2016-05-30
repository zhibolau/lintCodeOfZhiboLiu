Rotate Image


You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
把matrix旋转90度  in place方法  最优解这是！！！

Given a matrix

[
    [1,2],
    [3,4]
]
rotate it by 90 degrees (clockwise), return

[
    [3,1],
    [4,2]
]


public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < (size + 1) / 2; j++) {
				// ij ji ij ji 背下来的！！！！！！！！！！！！！！！！！！！！！！！！！
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - j][i];
                matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
                matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
                matrix[j][size - 1 - i] = temp;
            }
        }
    }
}


