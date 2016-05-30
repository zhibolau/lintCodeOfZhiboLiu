Search a 2D Matrix II

找出这个matrix中target出现了几次 row col已排序过！

Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.


Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if (matrix == null || matrix.size() == 0) {
            return 0;
        }
        int row = matrix.size();
        int col = matrix.get(0).size();
        int rIndex = 0;
        int cIndex = col - 1;
        int count = 0;
        while (rIndex < row && cIndex >= 0) {
            int temp = matrix.get(rIndex).get(cIndex);
            if (temp == target) {
                count++;
                rIndex++;
                cIndex--;
            } else if (temp < target) {
                rIndex++;
            }  else {
                cIndex--;
            }
        }
        return count;
    }
}

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int rIndex = 0;
        int cIndex = col - 1;
        int count = 0;
        while (rIndex < row && cIndex >= 0) {
            int temp = matrix[rIndex][cIndex];
            if (temp == target) {
                count++;
                rIndex++;
                cIndex--;
            } else if (temp < target) {
                rIndex++;	//rIndex越大 数字越大
            }  else {
                cIndex--;//cIndex越小 数字越小
            }
        }
        return count;
    }
}






