public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
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
                    dp[i][j] = (A.charAt(i - 1) == B.charAt(j-1)?
                                dp[i-1][j-1] + 1 : 0);   // 只要不一样 则dp为0， 就不再根据之前的dp值记录当前dp值！！！！！！！！！！！！！！
								// dp[][] 当中的值为0可以， 我们要的是max， 只要 char一样时更新max就可以了
								//注意 dp2维数组是dp2维数组 跟 max值无关 不要放在dp[][] 中更新max！！！！！！！！！！
                                if (dp[i][j]>max){
                                    max = dp[i][j];
                                }
                                
            }
        }
        return max;
    }
}


http://www.cnblogs.com/yuzhangcmu/p/4199499.html