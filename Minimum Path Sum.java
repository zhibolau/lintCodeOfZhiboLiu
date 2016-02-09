public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        
        path[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){//从1开始 因为0位基点
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        
        for(int i = 1; i < n; i++){
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < m; i++){//m为长度最终到不了m
            for(int j = 1; j < n; j++){
            path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
            }
        }
        return path[m-1][n-1];
        
        
    }
}

