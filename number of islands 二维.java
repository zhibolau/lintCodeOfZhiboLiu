
【解析】
题意：一个只包含字符0和1的二维数组，找出里面不相邻的只包含1的块的个数。

思路：DFS、BFS。只要遍历一遍，碰到一个1，就把它周围所有相连的1都标记为非1，这样整个遍历过程中碰到的1的个数就是所求解。





public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    rst++;
                    mark(grid, i, j);
                }
            }
        }
        return rst;
    }
    private void mark(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == false) {
        	return;
        }
        grid[i][j] = false;
        mark(grid, i + 1, j);
        mark(grid, i - 1, j);
        mark(grid, i, j + 1);
        mark(grid, i, j - 1);
    }
}