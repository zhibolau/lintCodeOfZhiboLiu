public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; ++i) {
            for (int j = m; j >= A[i]; --j) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}



Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?				