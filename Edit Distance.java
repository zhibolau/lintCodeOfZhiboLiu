public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int len1 = word1.length();
        int len2 = word2.length();
        int [][]dp = new int [len1 + 1][len2 + 1];
        //dp[i][j]表示word1的前i个字符要想与word2的前j个字符一样所花费最少的步数
        //加1 是因为 要从0 开始
        // 并且画图可知 要用 横轴 纵轴 各自为0的点计算其他点
        for(int i = 0; i < len2 + 1; i ++){
            // word1 不变，word2在变
            dp[0][i] = i;
        }
        
        for(int i = 0; i < len1 + 1; i ++){
            dp[i][0] = i;
        }
        
        for (int i = 1; i<len1 + 1; i ++){
            for (int j = 1; j<len2 + 1; j ++){
                //如果1的第i个等于2的第j个字符
                //charAt index from 0; 所以减1
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    //要从word第一个字母开始看
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    //insert ： a ab a中插入b a在i 所以b在i+1， i+1 = j
                    // 所以看 i与j-1
                    dp[i][j]= 1+ Math.min(dp[i-1][j-1] , Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        
        return dp[len1][len2]; //看图
    }
}
