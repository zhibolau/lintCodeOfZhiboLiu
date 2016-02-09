public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
       if(s3.length()!=s1.length()+s2.length()) 
       return false;    
        
       boolean [][] dp = new boolean [s1.length()+1][s2.length()+1];
       dp[0][0]=true;
       // s2是空 所以 才全是 true
       for(int i = 1; i<=s1.length() && s1.charAt(i-1)==s3.charAt(i-1); i++)
           dp[i][0]=true;
       // s1是空 所以 才全是 true
       for(int i = 1; i<=s2.length() && s2.charAt(i-1)==s3.charAt(i-1); i++)
           dp[0][i]=true;
       
       for(int i = 1; i <= s1.length(); i++){
           for(int j = 1; j <= s2.length(); j++){
               char c = s3.charAt(i+j-1);//???????????????????????????????????????????
               //i=1 j=1, i+j-1 = 1, s3实际从第二位开始看的 因为charAt indexfrom 0
               // 为啥这样？？？？？？？？？？
               
               //此时是s1中的字母与s3中的同，所以要看s1中的上一个是不是使dp也为true
               //so it is dp[i-1][j]
               if(c == s1.charAt(i-1) && dp[i-1][j])
                 dp[i][j] = true;
                 
               if(c == s2.charAt(j-1) && dp[i][j-1])
                 dp[i][j] = true;
           }
       }
      return dp[s1.length()][s2.length()];
    }
}