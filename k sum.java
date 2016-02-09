// public class Solution {
//     /**
//      * @param A: an integer array.
//      * @param k: a positive integer (k <= length(A))
//      * @param target: a integer
//      * @return an integer
//      */
//   // 2 dimension维度
//     public int  kSum(int A[], int k, int target) {
//         // write your code here
//         if (target < 0) {
//             return 0;
//         }
        
//         int len = A.length;
        
//         // D[i][j]: k = i, target j, the solution.
//         int[][] D = new int[k + 1][target + 1];
        
//         // only one solution for the empty set.
//         D[0][0] = 1;
//         for (int i = 1; i <= len; i++) {
//             for (int t = target; t > 0; t--) {
//                 for (int j = 1; j <= k; j++) {
//                     if (t - A[i - 1] >= 0) {
//                         D[j][t] += D[j - 1][t - A[i - 1]];
//                     }
//                 }
//             }
//         }
        
//         return D[k][target];
//     }
// }

看笔记照片好理解  在云盘刷题文件夹中
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    //f[i][j][t] = 0;   没有他也可以 是不是就说明 他只是个赋值 没有他也自动赋值为0
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];//+= = 此处都行
                    }
                    f[i][j][t] += f[i - 1][j][t];
                } // for t
            } // for j
        } // for i
        return f[n][k][target];
    }
}