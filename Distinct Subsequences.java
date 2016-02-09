public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int sLength = S.length();
        int tLength = T.length();
        
        int [][]dp = new int [sLength + 1][tLength + 1];
        
        // if (S == "" && T == ""){
            dp[0][0] = 1;
        //}
        //if (S == "" && T != ""){
            for (int j = 1; j<= tLength; j++){
                dp[0][j] = 0;
            }
        //}
        //if (T == "" && S != ""){
            for (int i = 1; i<= sLength; i++){
                dp[i][0] = 1;
            }
        //}
        //else{
            for(int i = 1; i<= sLength; i++){
                for (int j = 1; j<= tLength; j++){
                    dp[i][j]= dp[i-1][j] + (S.charAt(i-1) == T.charAt(j-1)? dp[i-1][j-1] : 0);
                }
            }
        //}
        return dp[sLength][tLength];
        
    }
}
http://blog.csdn.net/abcbc/article/details/8978146

看我自己的图 在 360云盘 图片 刷题 中