Triangle
找到路径sum最小
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
    	if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int[] dp = new int[size];
        for (int i = 0; i < size; ++i) {
            dp[i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}



int[][]:

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        
        int size = triangle.length;
        int[] dp = new int[size];
        for(int i= 0 ; i<size; i++){
            dp[i] = triangle[size-1][i];
        }
        
        for(int i = size - 2; i>=0; i--){
            for(int j = 0; j <=i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle[i][j];
            }
        }
        
        return dp[0];
    }
}



