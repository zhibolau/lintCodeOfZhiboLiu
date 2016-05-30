Search a 2D Matrix

看看此matrix是否有此目标 ！  每行都是递增 

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.


public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left < right - 1){ //用于找到那个可能包含target的1位数组 然后在用二分查找
            int mid = left + (right - left)/2;
            if (matrix[mid][0] == target){
                return true;
            }
            else if (matrix[mid][0] > target){
                right = mid; // 此时不加1或者减1 是因为 
				//target还有可能在此区间内，一个nums【】有好几个元素
            }
            else {
                left = mid;
            }
        }
        if (target < matrix[left][0]){
            return false;
        }
        else if (target > matrix[right][0]){
            return search (matrix[right], target);
        }
        else {
            return search (matrix[left], target);
        }
    }
    
    public boolean search(int[] nums, int target){ //可以用public吗？？？？？？
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int mid = start +(end - start)/2;
            if (nums[mid] == target){
                return true;
            }
            else if (nums[mid] < target){
                start = mid + 1; // 此时可以排除掉mid元素 因为不再是nums【】了 
            }
            else {
                end = mid - 1;
            }
        }
        return nums[start] == target || nums[end] == target;
    }
}





以下的明白了！！！！！！： ！！！！！！！！！！！！！！！！！！！！！！！！！！
arrayList
int[]
其他一样


import java.util.ArrayList;

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if (matrix == null || matrix.size() == 0) {
            return false;
        }
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int start = 0;
        int end = rows * cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int digit = matrix.get(mid / cols).get(mid % cols);//mid / cols 是看当前数在第几行row 
			//mid % cols 是看当前数是在第几列 col
            if (digit == target) {//看mid与target一样否
                return true;
            } else if (digit < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix.get(start / cols).get(start % cols) == target) {//看start与target一样否
            return true;
        }
        if (matrix.get(end / cols).get(end % cols) == target) {//看end与target一样否
            return true;
        }
        return false;
    }
}


public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int digit = matrix[mid / cols][mid % cols];
            if (digit == target) {
                return true;
            } else if (digit < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / cols][start % cols] == target) {
            return true;
        }
        if (matrix[end / cols][end % cols] == target) {
            return true;
        }
        return false;
    }
}


