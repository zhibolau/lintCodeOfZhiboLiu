public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        
        if (triangle == null || triangle.length == 0){
            return 0;
        }
        int len = triangle.length;
        
        int []dp = new int[len + 1];//1 is for dp(i+1) below
        while( --len >= 0){
            int [] cur = triangle[len];
            for(int i = 0; i <= len; i++){//i 可以等于len， 因为之前--过了
                /*
                    Each step you may move to adjacent numbers on the row below.
                */
                dp[i] = cur[i] + Math.min(dp[i+1], dp[i]);
            }
        }
        return dp[0];
    }
}

