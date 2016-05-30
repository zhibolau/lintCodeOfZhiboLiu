public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
          return 0;
        }
        int longest = 1;
        int tempIncrease = 1;
        int tempDecrease = 1;
        for (int i = 0; i < A.length - 1; i ++) {
          if (A[i] < A[i + 1]) {
            tempIncrease++;
            tempDecrease = 1;
            longest = Math.max(longest, tempIncrease);
          } else {
            tempDecrease++;
            tempIncrease = 1;
            longest = Math.max(longest, tempDecrease);
          }
        }
        return longest;
    }
}


Can be from right to left or from left to right. ！！！！！！！！！！！！！！！！！！！！！！！！！！！

mine：


public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        int len = A.length;
        if(A == null || len == 0){
            return 0;
        }
        
        int longest = 1;////因为一出现就是两个 所以 要从1开始
        int tempIncrease = 1;
        int tempDecrease = 1;
        for(int i = 0; i<len- 1; i++){
            if(A[i] < A[i+1]){
                //因为一出现就是两个 所以 temp要从1开始
                tempIncrease++;
                tempDecrease = 1;
                longest = Math.max(longest, tempIncrease);
            }
            else{
                tempDecrease++;
                tempIncrease = 1;
                longest = Math.max(longest, tempDecrease);
            }
                
        }
        return longest;
    }
}