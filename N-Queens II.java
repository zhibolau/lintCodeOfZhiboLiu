class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
     int res;
    public int totalNQueens(int n) {
        res = 0;
        if(n <= 0){
            return res;
        }
        int[] columnValue = new int[n];
        dfs(0, n, columnValue);
        return res;
    }
    
    public void dfs(int row, int n, int[] columnValue){
        if(row == n){
            res += 1;
        }
        else{
            for(int i = 0; i < n; i++){
                columnValue[row] = i;
                if(isValid(row, columnValue)){
                    dfs(row + 1, n, columnValue);
                }
            }
        }
    }
    public boolean isValid(int row, int[] columnValue){
        for (int i = 0; i < row; i++){
            if(columnValue[row] == columnValue[i] || Math.abs(columnValue[row] - columnValue[i]) == row - i){
                return false;
            }
        }
        return true;
    }
};



题解：

这道题跟NQueens的解法完全一样（具体解法参照N QueensN Queens leetcode java），只不过要求的返回值不同了。。所以要记录的result稍微改一下就好了。。。

因为涉及到递归，result传进去引用类型（List，数组之类的）才能在层层递归中得以保存，所以这里使用一个长度为1的数组帮助计数。

当然，也可以使用一个全局变量来帮助计数。



http://www.cnblogs.com/springfor/p/3870945.html