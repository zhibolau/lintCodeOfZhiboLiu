public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        if (m == 0 || n == 0) return 0;
        int [][] sum = new int [m][n];
        int i, j;
        for (i = 0; i <m; i++){
            sum[i][0] = 1;
        }
        for (j = 0; j <n; ++j){
            sum[0][j] = 1;
        }
        for (i = 1; i <m; ++i){//从1开始
            for (j = 1; j <n; ++j){
                sum[i][j] = sum[i-1][j] + sum[i][j-1];//either down or right 
            }
        }
        return sum[m-1][n-1];
    }
}

