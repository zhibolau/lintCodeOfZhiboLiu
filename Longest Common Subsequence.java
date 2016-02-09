public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int aLen = A.length();
        int bLen = B.length();
        int max = 0;
        
        int [][] dp = new int [aLen + 1][bLen + 1];
        for (int i =0; i <= aLen; i++){
            dp[i][0] = 0;
        }
        for (int i =0; i <= bLen; i++){
            dp[0][i] = 0;
        }
        for (int i =1; i <= aLen; i++){
                for (int j = 1; j <= bLen; j++){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // 经过一步一步带入i j 看例子 得出来的 
                    if (A.charAt(i - 1) == B.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                                
            }
        }
        return dp[aLen][bLen];
    }
    
}
看刷题图片详解


